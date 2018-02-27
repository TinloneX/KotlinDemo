package org.tinlone.demo.kotlindemo

import android.app.Application

/**
 * @author Tinlone on 2018/2/27 0027.
 */

class MyApplication : Application() {

    init {
        mApp = this
    }

    companion object {
        lateinit var mApp : MyApplication  // 定义全局唯一合法静态上下文
    }

}