package tech.thdev.simpleadapter

import androidx.recyclerview.widget.RecyclerView
import tech.thdev.simpleadapter.data.source.AdapterRepository
import tech.thdev.simpleadapter.data.source.AdapterRepositoryImpl
import tech.thdev.simpleadapter.holder.SimpleBaseViewHolder

abstract class SimpleBaseAdapter<VIEW_HOLDER : SimpleBaseViewHolder> :
    RecyclerView.Adapter<VIEW_HOLDER>(),
    AdapterRepository by AdapterRepositoryImpl() {

    override fun getItemViewType(position: Int): Int {
        return getViewType(position)
    }

    override fun onBindViewHolder(holder: VIEW_HOLDER, position: Int) {
        holder.onBindViewHolder(getItem(position))
    }
}