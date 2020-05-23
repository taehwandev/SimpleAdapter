package app.thdev.ui.adapter_control

import app.thdev.databinding.ItemTextViewBinding
import tech.thdev.simpleadapter.control.SimpleAdapterControl
import tech.thdev.simpleadapter.data.SimpleAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewHolder
import tech.thdev.simpleadapter.util.bindViewHolder

class SimpleAdapterControlSampleAdapterControl(
    private val onClick: (item: Int) -> Unit
) : SimpleAdapterControl<AdapterItemGroup>() {

    override fun SimpleAdapterCreateItem.onCreateSimpleViewHolder(): SimpleViewHolder<*, *> =
        bindViewHolder<ItemTextViewBinding, Int> { item ->
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