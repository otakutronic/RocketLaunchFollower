package com.test.rocketlaunches.home.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.rocketlaunches.domain.model.Launch
import com.test.rocketlaunches.domain.util.getLocalTimeFromUnix
import com.test.rocketlaunches.home.R
import com.test.rocketlaunches.home.ui.HomeAdapter
import com.test.rocketlaunches.domain.model.Result

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

@BindingAdapter("app:loading")
fun setLoading(progressBar: ProgressBar, result: Result<List<Launch>>) {
    progressBar.visibility = if (result is Result.Loading)
        View.VISIBLE
    else
        View.GONE
}
