package tech.thdev.simpleadapter.util

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import tech.thdev.simpleadapter.data.SimpleDataBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleDataBindingViewHolder

inline fun SimpleDataBindingAdapterCreateItem.createDataBindingHolder(
    layoutRes: Int
): SimpleDataBindingViewHolder =
    SimpleDataBindingViewHolder(
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    )