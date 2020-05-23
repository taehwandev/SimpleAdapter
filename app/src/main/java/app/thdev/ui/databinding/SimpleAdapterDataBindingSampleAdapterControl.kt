package app.thdev.ui.databinding

import androidx.lifecycle.ViewModel
import app.thdev.R
import tech.thdev.simpleadapter.SimpleDataBindingAdapter
import tech.thdev.simpleadapter.control.SimpleDataBindingAdapterControl
import tech.thdev.simpleadapter.data.SimpleDataBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleDataBindingViewHolder
import tech.thdev.simpleadapter.util.createDataBindingHolder

class SimpleAdapterDataBindingSampleAdapterControl :
    SimpleDataBindingAdapterControl<AdapterDataBindingItemGroup>() {

    /**
     * CreateItem is parentView, viewType support.
     */
    override fun SimpleDataBindingAdapterCreateItem.onCreateViewHolder(): SimpleDataBindingViewHolder {
        return when (viewType) {
            else -> createDataBindingHolder(R.layout.item_data_binding_text_view)
        }
    }


    /**
     * add Item and ViewModel
     */
    override fun SimpleDataBindingAdapter.onCreateItems(
        item: AdapterDataBindingItemGroup,
        viewModel: ViewModel?
    ) {
        val startPosition = getItemSize()
        var newItem = 0
        // AddItem.
        item.itemList.forEach {
            newItem++
            addItem(0, it, viewModel)
        }
        notifyItemRangeInserted(startPosition, newItem)
    }
}

data class AdapterDataBindingItemGroup(
    val itemList: List<AdapterDataBindingItem>
)

data class AdapterDataBindingItem(
    val index: Int
)