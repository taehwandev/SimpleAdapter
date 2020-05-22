package tech.thdev.simpleadapter

import tech.thdev.simpleadapter.holder.SimpleBaseViewHolder

abstract class SimpleAdapterControl<ITEM : Any> {

    val adapter: SimpleAdapter by lazy {
        SimpleAdapter {
            onCreateSimpleViewHolder()
        }
    }

    /**
     * Use bindViewHolder
     */
    abstract fun SimpleAdapterCreateItem.onCreateSimpleViewHolder(): SimpleBaseViewHolder<*>
}