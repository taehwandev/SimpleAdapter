package tech.thdev.simpleadapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SimpleViewHolder<in ITEM : Any>(
    layoutRes: Int,
    parent: ViewGroup,
    private val body: View.(item: ITEM) -> Unit
) : BaseViewHolder<ITEM>(layoutRes, parent) {

    override fun onBindViewHolder(item: ITEM) {
        itemView.body(item)
    }
}

abstract class BaseViewHolder<in ITEM : Any>(
    layoutRes: Int,
    parent: ViewGroup
) : AndroidViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
) {

    protected val context: Context =
        itemView.context

    @Suppress("UNCHECKED_CAST")
    fun safeOnBindViewHolder(item: Any) {
        try {
            onBindViewHolder(item as ITEM)
        } catch (e: Exception) {
            // Exception.
            e.printStackTrace()
        }
    }

    abstract fun onBindViewHolder(item: ITEM)
}