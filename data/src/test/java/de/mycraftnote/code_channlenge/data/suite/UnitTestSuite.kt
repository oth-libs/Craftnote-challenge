package io.shortly.data.suite

import de.mycraftnote.code_channlenge.data.remote.api.ProjectsServiceTest
import de.mycraftnote.code_channlenge.data.remote.datasource.RemoteDataSourceTest
import de.mycraftnote.code_channlenge.data.remote.mapper.MapperProjectsRetrofitModelToModelTest
import de.mycraftnote.code_channlenge.data.repository.ProjectsRepositoryTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
  ProjectsServiceTest::class,
  RemoteDataSourceTest::class,
  MapperProjectsRetrofitModelToModelTest::class,
  ProjectsRepositoryTest::class,
)
internal class UnitTestSuite