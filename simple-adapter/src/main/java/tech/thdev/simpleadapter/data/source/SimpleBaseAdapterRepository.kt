package tech.thdev.simpleadapter.data.source

interface SimpleBaseAdapterRepository<ITEM : Any?> {

    fun getItemSize(): Int

    fun getItem(position: Int): ITEM

    fun removeAt(position: Int)

    fun getViewType(position: Int): Int

    fun addItem(viewType: Int, item: ITEM)

    fun addItems(viewType: Int, items: List<ITEM>)

    fun clear()
}