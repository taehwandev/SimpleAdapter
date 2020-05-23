package tech.thdev.simpleadapter.holder

import androidx.viewbinding.ViewBinding
import tech.thdev.simpleadapter.data.SimpleViewBindingViewHolderItem


class SimpleViewBindingViewHolder<BINDING : ViewBinding, in ITEM : Any>(
    private val viewBinding: BINDING,
    viewType: Int = -1,
    private val bindViewHolder: SimpleViewBindingViewHolderItem<BINDING, ITEM>.() -> Unit
) : SimpleBaseViewHolder(
    viewBinding.root,
    viewType
) {

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(item: Any) {
        try {
            SimpleViewBindingViewHolderItem(viewBinding, item as ITEM)
                .bindViewHolder()
        } catch (e: Exception) {
            // ...
        }
    }
}
