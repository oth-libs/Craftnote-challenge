package de.mycraftnote.code_challenge.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import de.mycraftnote.code_challenge.extensions.visibleOrGone

@BindingAdapter("app:visibleOrGone") fun visibleOrGone(view: View, visible: Boolean?) {
  visible ?: return
  view.visibleOrGone(visible)
}
