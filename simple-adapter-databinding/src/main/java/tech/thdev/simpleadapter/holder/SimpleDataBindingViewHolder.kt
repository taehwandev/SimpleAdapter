package tech.thdev.simpleadapter.holder

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


class SimpleDataBindingViewHolder(
    private val viewBinding: ViewDataBinding
) : RecyclerView.ViewHolder(
    viewBinding.root
) {

    /**
     * ViewBinding single viewModel and item binding.
     */
    fun onBindViewHolder(viewModel: Any?, item: Any?) {
        viewModel?.let {
            viewBinding.setVariable(BR.viewModel, it)
        }
        item?.let {
            viewBinding.setVariable(BR.item, it)
        }
        viewBinding.executePendingBindings()
    }
}
