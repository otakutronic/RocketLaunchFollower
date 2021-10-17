package com.lush.rocketlaunches.home.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lush.rocketlaunches.domain.model.Launch
import com.lush.rocketlaunches.domain.util.getLocalTimeFromUnix
import com.lush.rocketlaunches.home.R
import com.lush.rocketlaunches.home.ui.HomeAdapter

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Launch>?) {
    items?.let {
        (listView.adapter as HomeAdapter).submitList(items)
    }
}

@BindingAdapter ( "imageURL" )
fun ImageView.imageURI (url: String?) {
    Glide.with ( this )
        .load (url)
        .placeholder(R.drawable.placeholder)
        .into ( this )
}

@BindingAdapter("app:date")
fun setDate(textView: TextView, launchDateUnix: Long?) {
    textView.text =
        if (launchDateUnix != null) getLocalTimeFromUnix(launchDateUnix) else
            textView.context.getString(R.string.launch_date_null)
}
