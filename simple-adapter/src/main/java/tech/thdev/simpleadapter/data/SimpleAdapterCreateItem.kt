package tech.thdev.simpleadapter.data

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

data class SimpleAdapterCreateItem(
    val parent: ViewGroup,
    val viewType: Int
)

data class SimpleViewHolderItem<BINDING: ViewBinding, ITEM : Any>(
    val binding: BINDING,
    val item: ITEM
)

internal data class AdapterItem(
    val viewType: Int,
    val item: Any
)