package tech.thdev.simpleadapter.data.source

import tech.thdev.simpleadapter.data.SimpleAdapterItem

abstract class AbstractSimpleBaseAdapterRepository<LIST_ITEM, ITEM : Any?> :
    SimpleBaseAdapterRepository<ITEM> {

    protected val list = mutableListOf<LIST_ITEM>()

    override fun getItemSize(): Int =
        list.size

    override fun removeAt(position: Int) {
        list.removeAt(position)
    }

    override fun addItems(viewType: Int, items: List<ITEM>) {
        items.forEach {
            addItem(viewType, it)
        }
    }

    override fun clear() {
        list.clear()
    }
}

internal class SimpleBaseAdapterRepositoryImpl :
    AbstractSimpleBaseAdapterRepository<SimpleAdapterItem, Any>() {

    override fun getItem(position: Int): Any =
        list[position].item

    override fun getViewType(position: Int): Int =
        list[position].viewType

    override fun addItem(viewType: Int, item: Any) {
        list.add(SimpleAdapterItem(viewType, item))
    }
}