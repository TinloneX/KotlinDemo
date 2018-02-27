package org.tinlone.demo.kotlindemo.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Tinlone on 2018/2/27 0027.
 */
@Parcelize
@SuppressLint("ParcelCreator") // 解决IntelliJ编译时报警告
class User(val firstName: String, var lastName: String, var age: Int):Parcelable