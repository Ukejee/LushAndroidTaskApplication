package com.ukejee.lushandroidtaskapplication.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.DecodeFormat
import com.ukejee.lushandroidtaskapplication.R


fun ImageView.setImage(url: String) {

    Glide.with(this.context)
        .load(url.ifEmpty { null })
        .format(DecodeFormat.PREFER_RGB_565)
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_no_pictures)
        .fitCenter()
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
