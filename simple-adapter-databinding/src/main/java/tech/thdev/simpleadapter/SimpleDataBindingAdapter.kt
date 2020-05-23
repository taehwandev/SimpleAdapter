package tech.thdev.simpleadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.simpleadapter.data.SimpleDataBindingAdapterCreateItem
import tech.thdev.simpleadapter.data.source.SimpleDataBindingAdapterRepository
import tech.thdev.simpleadapter.data.source.SimpleDataBindingAdapterRepositoryImpl
import tech.thdev.simpleadapter.holder.SimpleDataBindingViewHolder

class SimpleDataBindingAdapter(
    private val createViewHolder: SimpleDataBindingAdapterCreateItem.() -> SimpleDataBindingViewHolder
) : RecyclerView.Adapter<SimpleDataBindingViewHolder>(),
    SimpleDataBindingAdapterRepository<Any?> by SimpleDataBindingAdapterRepositoryImpl() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimpleDataBindingViewHolder =
        SimpleDataBindingAdapterCreateItem(parent, viewType).createViewHolder()

    override fun onBindViewHolder(holder: SimpleDataBindingViewHolder, position: Int) {
        getBindingItem(position).let {
            holder.onBindViewHolder(it.viewModel, it.item)
        }
    }

    override fun getItemCount(): Int =
        getItemSize()

    override fun getItemViewType(position: Int): Int =
        getViewType(position)
}
