package tech.thdev.simpleadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.simpleadapter.data.source.AdapterRepository
import tech.thdev.simpleadapter.data.source.AdapterRepositoryImpl
import tech.thdev.simpleadapter.holder.SimpleBaseViewHolder

class SimpleAdapter(
    private val onCreateHolder: SimpleAdapterCreateItem.() -> SimpleBaseViewHolder<*>
) : RecyclerView.Adapter<SimpleBaseViewHolder<*>>(),
    AdapterRepository by AdapterRepositoryImpl() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleBaseViewHolder<*> =
        SimpleAdapterCreateItem(parent, viewType).onCreateHolder()

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: SimpleBaseViewHolder<*>, position: Int) {
        holder.safeOnBindViewHolder(getItem(position))
    }
}

data class SimpleAdapterCreateItem(
    val parent: ViewGroup,
    val viewType: Int
)