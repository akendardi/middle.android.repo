package com.example.androidpracticumcustomview.screen2

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.androidpracticumcustomview.R

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context, attrs, defStyleAttr, defStyleRes
) {
    private val paint = Paint()
    private var color = 0
    private var innerCircleRadius = 0f

    fun setRectangleColor(color: Int) {
        this.color = color
        paint.color = color
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = width + paddingEnd + paddingStart
        val desiredHeight = height + paddingTop + paddingBottom

        val width = resolveSize(desiredWidth, widthMeasureSpec)
        val height = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }

    private fun getPathForRect(): Path {
        val path = Path()

        path.lineTo(
            width + paddingEnd.toFloat(),
            paddingTop.toFloat()
        )

        path.lineTo(
            width + paddingEnd.toFloat(),
            height + paddingBottom.toFloat()
        )

        path.lineTo(
            paddingStart.toFloat(),
            height + paddingBottom.toFloat()
        )

        path.lineTo(
            paddingStart.toFloat(),
            paddingTop.toFloat()
        )

        path.moveTo(
            paddingStart + width.toFloat() / 4,
            paddingTop + height.toFloat() / 4
        )
        path.lineTo(
            paddingStart + width.toFloat() / 4,
            height.toFloat() - paddingBottom - height.toFloat() / 4
        )
        path.lineTo(
            width.toFloat() - width.toFloat() / 4 - paddingEnd,
            height.toFloat() - paddingBottom - height.toFloat() / 4
        )
        path.lineTo(
            width.toFloat() - width.toFloat() / 4 - paddingEnd,
            paddingTop + height.toFloat() / 4
        )
        path.lineTo(
            paddingStart + width.toFloat() / 4,
            paddingTop + height.toFloat() / 4
        )

        return path
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val left = paddingStart.toFloat()
        val top = paddingTop.toFloat()
        val right = left + width
        val bottom = top + height

        canvas.clipPath(getPathForRect())

        canvas.drawRect(
            left, top, right, bottom, paint
        )


    }

    private fun init(
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        val typedArray: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            defStyleAttr,
            defStyleRes
        )

        color = context.getColor(R.color.teal_200)

        try {
            color = typedArray.getColor(
                R.styleable.CustomView_custom_rectangle_color,
                color
            )
            innerCircleRadius = typedArray.getDimension(
                R.styleable.CustomView_custom_inner_circle_radius,
                innerCircleRadius
            )
        } finally {
            typedArray.recycle()
        }

        paint.color = color
    }

    init {
        init(
            attrs, defStyleAttr, defStyleRes
        )
    }
}