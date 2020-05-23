package app.thdev.ui.adapter_control

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import app.thdev.R
import app.thdev.databinding.AdapterControlSampleFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SimpleAdapterControlSampleFragment : Fragment() {

    private val adapterControl: SimpleAdapterControlSampleAdapterControl by lazy {
        SimpleAdapterControlSampleAdapterControl {
            Toast.makeText(requireContext(), "message $it", Toast.LENGTH_SHORT).show()
        }
    }

    private lateinit var binding: AdapterControlSampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return AdapterControlSampleFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPrev.setOnClickListener {
            findNavController().navigate(R.id.action_AdapterControlSample_to_AdapterSample)
        }

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_AdapterControlSample_to_DataBindingSample)
        }

        binding.recyclerView.run {
            adapter = adapterControl.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterControl.setItem(
            AdapterItemGroup(itemList = (1..100).toList())
        )
    }
}