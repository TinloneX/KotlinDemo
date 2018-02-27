package org.tinlone.demo.kotlindemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.synthetic.main.activity_main.*
import org.tinlone.demo.kotlindemo.config.Values

@ContainerOptions(cache = CacheImplementation.NO_CACHE)
class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHello.text = Values.HELLO_KOTLIN
        btnButter.text = Values.BTN_CLICK
        btnButter.setOnClickListener {
            tvHello.text = Values.BTN_CLICK
            Toast.makeText(this, Values.BTN_CLICK, Toast.LENGTH_SHORT)
        }
    }
}
