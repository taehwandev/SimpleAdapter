package tech.thdev.simpleadapter.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import tech.thdev.simpleadapter.data.SimpleViewBindingAdapterCreateItem
import tech.thdev.simpleadapter.holder.SimpleViewBindingViewHolder

@Deprecated("It's a dangerous call. Use the following method by calling Binding, use createViewBindingHolder or DataBinding.")
inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleViewBindingAdapterCreateItem.createViewBindingHolder(
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewBindingViewHolder<BINDING, ITEM> {
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

    return SimpleViewBindingViewHolder(
        viewBinding = newBinding,
        viewType = viewType,
        bindViewHolder = {
            binding.onBindViewHolder(item)
        }
    )
}

inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleViewBindingAdapterCreateItem.createViewBindingHolder(
    viewBinding: BINDING,
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewBindingViewHolder<BINDING, ITEM> =
    SimpleViewBindingViewHolder(
        viewBinding = viewBinding,
        viewType = viewType,
        bindViewHolder = {
            this.binding.onBindViewHolder(item)
        }
    )