package tech.thdev.simpleadapter.data.source

import tech.thdev.simpleadapter.data.SimpleDataBindingItem

internal class SimpleDataBindingAdapterRepositoryImpl :
    AbstractSimpleBaseAdapterRepository<SimpleDataBindingItem, Any?>(),
    SimpleDataBindingAdapterRepository<Any?> {

    override fun getItem(position: Int): Any? =
        getBindingItem(position).item

    override fun getBindingItem(position: Int): SimpleDataBindingItem =
        list[position]

    override fun getViewType(position: Int): Int =
        getBindingItem(position).viewType

    override fun addItem(viewType: Int, item: Any?) {
        addItem(viewType, item, null)
    }

    override fun addItem(viewType: Int, item: Any?, viewModel: Any?) {
        list.add(SimpleDataBindingItem(viewType, item, viewModel))
    }
}