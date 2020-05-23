package tech.thdev.simpleadapter

import android.view.ViewGroup
import tech.thdev.simpleadapter.data.SimpleViewBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewBindingViewHolder

class SimpleViewBindingAdapter(
    private val createViewHolder: SimpleViewBindingAdapterCreateItem.() -> SimpleViewBindingViewHolder<*, *>
) : SimpleBaseAdapter<SimpleViewBindingViewHolder<*, *>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimpleViewBindingViewHolder<*, *> =
        SimpleViewBindingAdapterCreateItem(parent, viewType).createViewHolder()
}
