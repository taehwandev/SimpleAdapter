package tech.thdev.simpleadapter.data.source

import tech.thdev.simpleadapter.data.SimpleDataBindingItem

interface SimpleDataBindingAdapterRepository<ITEM : Any?> : SimpleBaseAdapterRepository<ITEM> {

    fun getBindingItem(position: Int): SimpleDataBindingItem

    fun addItem(viewType: Int, item: ITEM, viewModel: Any?)
}