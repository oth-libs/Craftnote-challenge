package de.mycraftnote.code_channlenge.data.remote.datasource

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import de.mycraftnote.code_channlenge.data.factory.Factory
import de.mycraftnote.code_channlenge.data.remote.api.ProjectsService
import de.mycraftnote.code_channlenge.data.remote.mapper.MapperProjectsRetrofitModelToModel
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.net.HttpURLConnection
import kotlin.test.assertEquals

internal class RemoteDataSourceTest {

  private val mockWebServer = MockWebServer()
  private lateinit var projectsService: ProjectsService
  private val json = Json { ignoreUnknownKeys = true }

  @ExperimentalSerializationApi
  @Before
  fun setup() {
    mockWebServer.start()

    projectsService = Retrofit.Builder()
      .baseUrl(mockWebServer.url("/"))
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .build()
      .create(ProjectsService::class.java)
  }

  @After
  fun tearDown() {
    mockWebServer.shutdown()
  }

  @Test
  fun testGetRemoteResult() = runBlocking {

    val expected = Factory.projectsRetrofitModel1

    val response = MockResponse()
      .setResponseCode(HttpURLConnection.HTTP_OK)
      .setBody(Json.encodeToString(expected))

    mockWebServer.enqueue(response)

    val remoteResult = RemoteDataSource.getRemoteResult(
      call = { projectsService.getProjects() },
      map = { MapperProjectsRetrofitModelToModel.map(it) }
    )

    assertEquals(remoteResult.status, DataSourceResultHolder.Status.SUCCESS)
    assertEquals(remoteResult.data, Factory.projectsModel1)
  }

  @Test
  fun testGetRemoteResultError() = runBlocking {

    val response = MockResponse()
      .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)

    mockWebServer.enqueue(response)

    val remoteResult = RemoteDataSource.getRemoteResult(
      call = { projectsService.getProjects() },
      map = { MapperProjectsRetrofitModelToModel.map(it) }
    )

    assertEquals(remoteResult.status, DataSourceResultHolder.Status.ERROR)
    assertEquals(remoteResult.data, null)
  }

}