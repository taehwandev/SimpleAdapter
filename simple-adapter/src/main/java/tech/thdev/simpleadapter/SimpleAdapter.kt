package tech.thdev.simpleadapter

import android.view.ViewGroup
import tech.thdev.simpleadapter.data.SimpleAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleBaseViewHolder
import tech.thdev.simpleadapter.holder.SimpleViewHolder

class SimpleAdapter(
    private val onCreateHolder: SimpleAdapterCreateItem.() -> SimpleViewHolder<*, *>
) : SimpleBaseAdapter<SimpleViewHolder<*, *>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder<*, *> {
        val view = SimpleAdapterCreateItem(parent, viewType).onCreateHolder()
        android.util.Log.d("TEMP", "onCreateViewHolder $viewType view ${view.hashCode()}")
        return view
    }
}
