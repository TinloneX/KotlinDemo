package org.tinlone.demo.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.tinlone.demo.kotlindemo.R
import org.tinlone.demo.kotlindemo.bean.User
import org.tinlone.demo.kotlindemo.config.Randoms

/**
 * @author Administrator on 2018/2/27 0027.
 */
class UsersListAdapter() : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_text, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = list[position]
        holder?.tvUser?.text = "name: ${user.firstName}.${user.lastName}, age:${user.age}"
        holder?.tvUser?.setBackgroundColor(bgColors[position])
        holder?.tvUser?.setTextColor(txtColors[position])
        holder?.itemView?.setOnClickListener { mListener.onClick(position) }
    }

    lateinit var list: List<User>
    lateinit var bgColors: List<Int>
    lateinit var txtColors: List<Int>
    lateinit var mListener: OnItemClick

    constructor(data: List<User>, listener: OnItemClick) : this() {
        list = data
        mListener = listener
        bgColors = Randoms.colors(list.size)
        txtColors = Randoms.colors2(list.size)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvUser: TextView? = itemView?.findViewById(R.id.tvUser)
    }

    interface OnItemClick{
       fun onClick(position: Int)
    }

}