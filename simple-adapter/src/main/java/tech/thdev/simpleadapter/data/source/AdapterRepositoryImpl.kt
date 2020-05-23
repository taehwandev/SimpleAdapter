package tech.thdev.simpleadapter.data.source

import tech.thdev.simpleadapter.data.AdapterItem

internal class AdapterRepositoryImpl : AdapterRepository {

    private val list = mutableListOf<AdapterItem>()

    override fun getItemCount(): Int =
        list.size

    override fun getItem(position: Int): Any =
        list[position].item

    override fun removeAt(position: Int) {
        list.removeAt(position)
    }

    override fun getViewType(position: Int): Int =
        list[position].viewType

    override fun addItem(viewType: Int, item: Any) {
        list.add(AdapterItem(viewType, item))
    }

    override fun addItems(viewType: Int, items: List<Any>) {
        items.forEach {
            addItem(viewType, it)
        }
    }

    override fun clear() {
        list.clear()
    }
}