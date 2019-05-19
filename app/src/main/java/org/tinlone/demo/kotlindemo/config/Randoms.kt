package org.tinlone.demo.kotlindemo.config

import android.graphics.Color
import java.util.*

/**
 * @author Administrator on 2018/2/27 0027.
 */
class Randoms {

    companion object {
        var randomColor = Color.rgb(Random().nextInt(255), Random().nextInt(255), Random().nextInt(255))

        fun colors(number: Int): List<Int> {
            val ints: MutableList<Int> = mutableListOf()
            for (i in 0..number) {
                ints.add(Color.rgb(Random().nextInt(255 - i * 10), Random().nextInt(255 - i * 6), Random().nextInt(255 - i * 4)))
            }
             return ints
        }

        fun colors2(number: Int): List<Int> {
            val ints: MutableList<Int> = mutableListOf()
            for (i in 0..number) {
                ints.add(Color.rgb(Random().nextInt(127 + i * 10), Random().nextInt(127 + i * 6), Random().nextInt(127 + i * 4)))
            }
             return ints
        }


    }


}