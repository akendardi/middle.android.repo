package com.example.androidpracticumcustomview.screen2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.androidpracticumcustomview.R

class CustomViewGroup @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(
    context,
    attributeSet,
    defStyleAttr
) {


    private fun onLayoutFirstChild(
        startX: Int,
        startY: Int,
        parentHeight: Int
    ) {
        val firstChild = getChildAt(0)


        val firstChildWidth = firstChild.measuredWidth
        val firstChildHeight = firstChild.measuredHeight

        firstChild.layout(
            startX - firstChildWidth / 2,
            startY - firstChildHeight,
            startX + firstChildWidth / 2,
            startY
        )

        animateAlpha(firstChild)

        animateTranslationY(
            -parentHeight / 2f + firstChildHeight,
            firstChild
        )
    }

    private fun animateAlpha(
        child: View
    ) {
        child.alpha = 0f
        child.animate()
            .alpha(1f)
            .setDuration(2000)
    }

    private fun animateTranslationY(
        endY: Float,
        view: View
    ) {
        view.animate()
            .translationY(endY)
            .setDuration(5000)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        if (childCount > 0) {

            val parentWidth = right - left
            val parentHeight = bottom - top
            val startX = parentWidth / 2
            val startY = parentHeight / 2

            onLayoutFirstChild(
                startX, startY, parentHeight
            )

            if (childCount > 1) {
                onLayoutSecondChild(
                    startY, startX, parentHeight
                )
            }
        }


    }

    private fun onLayoutSecondChild(
        startY: Int,
        startX: Int,
        parentHeight: Int
    ) {
        val secondChild = getChildAt(1)

        val secondChildWidth = secondChild.measuredWidth
        val secondChildHeight = secondChild.measuredHeight
        secondChild.layout(
            startX - secondChildWidth / 2,
            startY,
            startX + secondChildWidth / 2,
            startY + secondChildHeight
        )

        animateAlpha(secondChild)
        animateTranslationY(parentHeight / 2f - secondChildHeight, secondChild)
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_group, this, true)
        if (childCount > 2) {
            throw IllegalStateException("ViewGroup can have only 2 children")
        }
    }

}