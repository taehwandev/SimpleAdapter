package tech.thdev.simpleadapter.control

import tech.thdev.simpleadapter.SimpleViewBindingAdapter
import tech.thdev.simpleadapter.data.SimpleViewBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewBindingViewHolder

abstract class SimpleViewBindingAdapterControl<ITEM : Any> {

    val adapter: SimpleViewBindingAdapter by lazy {
        SimpleViewBindingAdapter {
            onCreateViewHolder()
        }
    }

    /**
     * Use bindViewHolder
     */
    abstract fun SimpleViewBindingAdapterCreateItem.onCreateViewHolder(): SimpleViewBindingViewHolder<*, *>

    /**
     * adapter add item.
     * @param item Group data class.
     */
    abstract fun setItem(item: ITEM)

    fun notifyDataSetChanged() {
        adapter.notifyDataSetChanged()
    }

    fun notifyItemChanged(position: Int) {
        adapter.notifyItemChanged(position)
    }

    fun notifyItemRangeInserted(positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeInserted(positionStart, itemCount)
    }

    fun notifyItemMoved(fromPosition: Int, toPosition: Int) {
        adapter.notifyItemMoved(fromPosition, toPosition)
    }

    fun notifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount)
    }

    fun notifyItemRangeChanged(positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeChanged(positionStart, itemCount)
    }
}