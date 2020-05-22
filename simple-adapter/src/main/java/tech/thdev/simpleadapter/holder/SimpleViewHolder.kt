package tech.thdev.simpleadapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SimpleViewHolder<in ITEM : Any>(
    parent: ViewGroup,
    layoutRes: Int,
    viewType: Int,
    private val onBindViewHolder: View.(item: ITEM) -> Unit
) : SimpleBaseViewHolder<ITEM>(
    LayoutInflater.from(parent.context).inflate(layoutRes, parent, false),
    viewType
) {

    override fun onBindViewHolder(item: ITEM) {
        itemView.onBindViewHolder(item)
    }
}
