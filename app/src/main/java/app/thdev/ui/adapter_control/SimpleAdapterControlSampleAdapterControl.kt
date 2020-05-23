package app.thdev.ui.adapter_control

import app.thdev.databinding.ItemTextViewBinding
import tech.thdev.simpleadapter.control.SimpleViewBindingAdapterControl
import tech.thdev.simpleadapter.data.SimpleViewBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewBindingViewHolder
import tech.thdev.simpleadapter.util.createViewBindingHolder

class SimpleAdapterControlSampleAdapterControl(
    private val onClick: (item: Int) -> Unit
) : SimpleViewBindingAdapterControl<AdapterItemGroup>() {

    override fun SimpleViewBindingAdapterCreateItem.onCreateViewHolder(): SimpleViewBindingViewHolder<*, *> =
        createViewBindingHolder<ItemTextViewBinding, Int> { item ->
            textView.text = "Message $item"
            root.setOnClickListener {
                onClick(item)
            }
        }

    override fun setItem(item: AdapterItemGroup) {
        item.itemList.forEach {
            adapter.addItem(0, it)
        }
    }
}

data class AdapterItemGroup(
    val itemList: List<Int>
)