package org.tinlone.demo.kotlindemo.config

import org.tinlone.demo.kotlindemo.MyApplication
import org.tinlone.demo.kotlindemo.R

/**
 * @author Tinlone on 2018/2/27 0027.
 */
class Values{

    companion object {  // 定义静态量需要使用companion object包裹
        var HELLO_KOTLIN: String = MyApplication.mApp.getString(R.string.hello_kotlin) // 此处值可变故不能使用const val
        var BTN_CLICK: String = MyApplication.mApp.getString(R.string.btn_click)
    }

}