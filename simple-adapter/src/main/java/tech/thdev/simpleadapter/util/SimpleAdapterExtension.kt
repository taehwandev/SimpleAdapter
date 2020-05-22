package tech.thdev.simpleadapter.util

import android.view.View
import tech.thdev.simpleadapter.SimpleAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewHolder

inline fun <ITEM : Any> SimpleAdapterCreateItem.bindViewHolder(
    layoutRes: Int,
    noinline onBindViewHolder: View.(item: ITEM) -> Unit
): SimpleViewHolder<ITEM> =
    SimpleViewHolder(
        parent = parent,
        layoutRes = layoutRes,
        viewType = viewType,
        onBindViewHolder = onBindViewHolder
    )