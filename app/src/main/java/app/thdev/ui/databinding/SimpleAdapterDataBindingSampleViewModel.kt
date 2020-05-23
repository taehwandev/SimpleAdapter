package app.thdev.ui.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleAdapterDataBindingSampleViewModel(
    private val adapterControl: SimpleAdapterDataBindingSampleAdapterControl
) : ViewModel() {

    private val _showToast = MutableLiveData<Int>()
    val showToast: LiveData<Int> get() = _showToast

    fun initItem() {
        adapterControl.setItems(
            AdapterDataBindingItemGroup(
                (1..150).map {
                    AdapterDataBindingItem(it)
                }.toList()
            ),
            this@SimpleAdapterDataBindingSampleViewModel
        )
    }

    fun onClickItem(item: AdapterDataBindingItem) {
        _showToast.value = item.index
    }
}