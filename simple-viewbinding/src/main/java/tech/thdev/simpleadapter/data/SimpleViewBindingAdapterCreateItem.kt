package tech.thdev.simpleadapter.data

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

data class SimpleViewBindingAdapterCreateItem(
    val parent: ViewGroup,
    val viewType: Int
)

data class SimpleViewBindingViewHolderItem<BINDING : ViewBinding, ITEM : Any>(
    val binding: BINDING,
    val item: ITEM
)