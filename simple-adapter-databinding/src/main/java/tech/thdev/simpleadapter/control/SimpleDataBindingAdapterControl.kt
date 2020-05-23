package tech.thdev.simpleadapter.control

import androidx.lifecycle.ViewModel
import tech.thdev.simpleadapter.SimpleDataBindingAdapter
import tech.thdev.simpleadapter.data.SimpleDataBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleDataBindingViewHolder

abstract class SimpleDataBindingAdapterControl<ITEM : Any> {

    val adapter: SimpleDataBindingAdapter by lazy {
        SimpleDataBindingAdapter {
            onCreateViewHolder()
        }
    }

    /**
     * Use bindViewHolder
     */
    abstract fun SimpleDataBindingAdapterCreateItem.onCreateViewHolder(): SimpleDataBindingViewHolder

    /**
     * adapter add item.
     * @param item Group data class.
     */
    protected abstract fun SimpleDataBindingAdapter.onCreateItems(item: ITEM, viewModel: ViewModel?)

    fun setItems(item: ITEM, viewModel: ViewModel?) {
        adapter.onCreateItems(item, viewModel)
    }

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