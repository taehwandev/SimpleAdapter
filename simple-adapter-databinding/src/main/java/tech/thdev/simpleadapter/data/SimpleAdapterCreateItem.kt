package tech.thdev.simpleadapter.data

import android.view.ViewGroup

data class SimpleDataBindingItem(
    val viewType: Int,
    val item: Any?,
    val viewModel: Any? = null
)

data class SimpleDataBindingAdapterCreateItem(
    val parent: ViewGroup,
    val viewType: Int
)