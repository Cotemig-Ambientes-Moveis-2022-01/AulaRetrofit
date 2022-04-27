package br.com.cotemig.aularetrofit.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.aularetrofit.R
import br.com.cotemig.aularetrofit.models.Friend
import coil.load

class FriendAdapter(var context: Context, var list: List<Friend>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_friend, null)

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        avatar.load(list[position].picture)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = list[position].name

        var messages = view.findViewById<TextView>(R.id.messages)
        messages.text = list[position].messages.toString()

        return view
    }
}