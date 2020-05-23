package tech.thdev.simpleadapter.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import tech.thdev.simpleadapter.data.SimpleAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewHolder

@Deprecated("It's a dangerous call. Use the following method by calling Binding, call bindViewHolder or DataBinding.")
inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleAdapterCreateItem.bindViewHolder(
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewHolder<BINDING, ITEM> {
    val method = BINDING::class.java.getDeclaredMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )
    val newBinding = method.invoke(
        null,
        LayoutInflater.from(parent.context),
        parent,
        false
    ) as BINDING

    return SimpleViewHolder(
        viewBinding = newBinding,
        viewType = viewType,
        bindViewHolder = {
            binding.onBindViewHolder(item)
        }
    )
}

inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleAdapterCreateItem.bindViewHolder(
    viewBinding: BINDING,
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewHolder<BINDING, ITEM> =
    SimpleViewHolder(
        viewBinding = viewBinding,
        viewType = viewType,
        bindViewHolder = {
            this.binding.onBindViewHolder(item)
        }
    )