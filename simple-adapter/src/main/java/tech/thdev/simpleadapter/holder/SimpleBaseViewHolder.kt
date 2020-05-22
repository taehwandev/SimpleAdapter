package tech.thdev.simpleadapter.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class SimpleBaseViewHolder<in ITEM : Any>(
    itemView: View,
    protected val viewType: Int = -1
) : RecyclerView.ViewHolder(itemView) {

    protected val context: Context =
        itemView.context

    @Suppress("UNCHECKED_CAST")
    internal fun safeOnBindViewHolder(item: Any) {
        try {
            onBindViewHolder(item as ITEM)
        } catch (e: Exception) {
            // Exception.
            e.printStackTrace()
        }
    }

    abstract fun onBindViewHolder(item: ITEM)
}