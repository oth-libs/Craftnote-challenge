package de.mycraftnote.code_challenge.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import de.mycraftnote.code_challenge.R

fun Activity?.showMessage(@StringRes message: Int) {
  this?.let { showMessage(getString(message)) }
}

fun Activity?.showMessage(message: String) {
  this?.findViewById<View>(R.id.container)?.let {
    Snackbar.make(
      it,
      message,
      Snackbar.LENGTH_LONG
    ).show()
  }
}

