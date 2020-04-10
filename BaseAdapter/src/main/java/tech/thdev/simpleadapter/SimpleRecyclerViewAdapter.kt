package tech.thdev.simpleadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.simpleadapter.data.source.AdapterRepository
import tech.thdev.simpleadapter.data.source.AdapterRepositoryImpl
import tech.thdev.simpleadapter.holder.BaseViewHolder
import tech.thdev.simpleadapter.holder.SimpleViewHolder

inline fun <ITEM : Any> ViewGroup.bindViewHolder(
    layoutRes: Int,
    crossinline onBindViewHolder: View.(item: ITEM) -> Unit
): SimpleViewHolder<ITEM> =
    SimpleViewHolder<ITEM>(layoutRes, this) {
        onBindViewHolder(it)
    }

class SimpleRecyclerViewAdapter(
    private val onCreateHolder: ViewGroup.(viewType: Int) -> BaseViewHolder<*>
) : RecyclerView.Adapter<BaseViewHolder<*>>(),
    AdapterRepository by AdapterRepositoryImpl() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> =
        parent.onCreateHolder(viewType)

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.safeOnBindViewHolder(getItem(position))
    }
}