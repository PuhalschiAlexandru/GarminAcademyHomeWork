package com.alex.garminlesson1.structureexercise

import com.alex.garminlesson1.model.Rectangle

class Paint {
    var color: Long = 0x00FF00
    var strokeWidth: Int = 5
    fun drawRectangle(rect: Rectangle) {
        println("Drawing $rect color: $color stroke: $strokeWidth")
    }
}

fun render(paint: Paint?, rectangles: List<Rectangle?>) {
    paint?.color = 0xFF0000
    rectangles.forEach { rect ->
        rect?.let { it -> paint?.drawRectangle(it) }
    }
}