package de.mycraftnote.code_challenge.ui.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.mycraftnote.code_challenge.R
import kotlinx.android.synthetic.main.activity_task.toolbar

class TaskActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_task)

    setSupportActionBar(toolbar)
  }
}