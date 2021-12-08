package com.team4.boulderbuild.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("url")
fun ImageView.bindUrl(url: String?) {
    url.whenNotNull { loadUrl(it) }
}
