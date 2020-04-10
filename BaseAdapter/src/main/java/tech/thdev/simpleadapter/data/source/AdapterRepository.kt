package tech.thdev.simpleadapter.data.source

interface AdapterRepository {

    fun getItemCount(): Int

    fun getItem(position: Int): Any

    fun removeAt(position: Int)

    fun getItemViewType(position: Int): Int

    fun addItem(viewType: Int, item: Any)

    fun addItems(viewType: Int, items: List<Any>)

    fun clear()
}