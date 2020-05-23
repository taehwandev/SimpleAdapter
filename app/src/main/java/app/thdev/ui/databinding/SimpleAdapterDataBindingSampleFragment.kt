package app.thdev.ui.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import app.thdev.R
import app.thdev.databinding.AdapterDataBindingSampleFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SimpleAdapterDataBindingSampleFragment : Fragment() {

    private val adapterControl by lazy {
        SimpleAdapterDataBindingSampleAdapterControl()
    }

    private lateinit var binding: AdapterDataBindingSampleFragmentBinding

    private val viewModel by viewModels<SimpleAdapterDataBindingSampleViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                SimpleAdapterDataBindingSampleViewModel(
                    adapterControl
                ) as T
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return AdapterDataBindingSampleFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPrev.setOnClickListener {
            findNavController().navigate(R.id.action_AdapterDataBindingSample_to_AdapterControlSample)
        }

        binding.recyclerView.adapter = adapterControl.adapter

        viewModel.showToast.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "Show message $it", Toast.LENGTH_SHORT).show()
        })
        viewModel.initItem()
    }
}