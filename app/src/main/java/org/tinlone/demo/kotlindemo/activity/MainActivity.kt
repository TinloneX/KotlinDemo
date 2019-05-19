package org.tinlone.demo.kotlindemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.synthetic.main.activity_main.*
import org.tinlone.demo.kotlindemo.R
import org.tinlone.demo.kotlindemo.adapter.UsersListAdapter
import org.tinlone.demo.kotlindemo.bean.User
import org.tinlone.demo.kotlindemo.config.Datas
import org.tinlone.demo.kotlindemo.config.Values

@ContainerOptions(cache = CacheImplementation.NO_CACHE)
class MainActivity : AppCompatActivity(), UsersListAdapter.OnItemClick {

    lateinit var usersList: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        usersList = Datas.USERS_ARRAY.asList()
        rvUserList.layoutManager = LinearLayoutManager(this)
        val adapter = UsersListAdapter(usersList, this)
        rvUserList.adapter = adapter
    }

    private fun initView() {
        tvHello.text = Values.HELLO_KOTLIN
        btnButter.text = Values.BTN_CLICK
        btnButter.setOnClickListener {
            tvHello.text = Values.BTN_CLICK
            Toast.makeText(this, Values.BTN_CLICK, Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(position: Int) {
        val user = usersList[position]
        tvHello.text = "${user.firstName}.${user.lastName}"
        Toast.makeText(this, "limited access?${!user.limited}", Toast.LENGTH_SHORT).show()
    }
}
