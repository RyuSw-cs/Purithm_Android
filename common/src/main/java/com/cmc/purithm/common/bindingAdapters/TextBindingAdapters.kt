package com.cmc.purithm.common.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextBindingAdapters {
    @BindingAdapter("date")
    @JvmStatic
    fun TextView.setDate(date : String) {
        text = date.split("T")[0].replace("-", ".")
    }
}