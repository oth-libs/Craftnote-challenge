package de.mycraftnote.code_challenge.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import kotlin.math.max

class SquareTextView constructor(
  context: Context,
  attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    val size = max(measuredWidth, measuredHeight)
    val widthSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
    val heightSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)

    super.onMeasure(widthSpec, heightSpec)
  }

}