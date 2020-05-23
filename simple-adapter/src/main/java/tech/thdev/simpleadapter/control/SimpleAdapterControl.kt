package tech.thdev.simpleadapter.control

import tech.thdev.simpleadapter.SimpleAdapter
import tech.thdev.simpleadapter.data.SimpleAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewHolder

abstract class SimpleAdapterControl<ITEM : Any> {

    val adapter: SimpleAdapter by lazy {
        SimpleAdapter {
            onCreateSimpleViewHolder()
        }
    }

    /**
     * Use bindViewHolder
     */
    abstract fun SimpleAdapterCreateItem.onCreateSimpleViewHolder(): SimpleViewHolder<*, *>

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