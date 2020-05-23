package tech.thdev.simpleadapter

import androidx.recyclerview.widget.RecyclerView
import tech.thdev.simpleadapter.data.source.SimpleBaseAdapterRepository
import tech.thdev.simpleadapter.data.source.SimpleBaseAdapterRepositoryImpl
import tech.thdev.simpleadapter.holder.SimpleBaseViewHolder

abstract class SimpleBaseAdapter<VIEW_HOLDER : SimpleBaseViewHolder> :
    RecyclerView.Adapter<VIEW_HOLDER>(),
    SimpleBaseAdapterRepository<Any> by SimpleBaseAdapterRepositoryImpl() {

    override fun onBindViewHolder(holder: VIEW_HOLDER, position: Int) {
        holder.onBindViewHolder(getItem(position))
    }

    override fun getItemCount(): Int =
        getItemSize()

    override fun getItemViewType(position: Int): Int =
        getViewType(position)
}