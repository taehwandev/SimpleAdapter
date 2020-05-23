package tech.thdev.simpleadapter.holder

import androidx.viewbinding.ViewBinding
import tech.thdev.simpleadapter.data.SimpleViewHolderItem

class SimpleViewHolder<BINDING : ViewBinding, in ITEM : Any>(
    private val viewBinding: BINDING,
    viewType: Int = -1,
    private val bindViewHolder: SimpleViewHolderItem<BINDING, ITEM>.() -> Unit
) : SimpleBaseViewHolder(
    viewBinding.root,
    viewType
) {

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(item: Any) {
        try {
            SimpleViewHolderItem(viewBinding, item as ITEM).bindViewHolder()
        } catch (e: Exception) {
            // ...
        }
    }
}
