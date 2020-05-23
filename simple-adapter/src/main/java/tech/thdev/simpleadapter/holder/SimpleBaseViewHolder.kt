package tech.thdev.simpleadapter.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class SimpleBaseViewHolder(
    itemView: View,
    protected val viewType: Int = -1
) : RecyclerView.ViewHolder(itemView) {

    protected val context: Context =
        itemView.context

    abstract fun onBindViewHolder(item: Any)
}