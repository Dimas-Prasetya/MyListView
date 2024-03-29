package com.dimas.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item.view.*

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = heroes.size
}

private class ViewHolder constructor(private val view: View) {
    internal fun bind(hero: Hero) {
        with(view) {
            txt_name.text = hero.name
            txt_description.text = hero.description
            img_photo.setImageResource(hero.photo)
        }
    }
}
