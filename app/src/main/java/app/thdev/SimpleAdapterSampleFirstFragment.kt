package app.thdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import app.thdev.databinding.AdapterSampleFragmentBinding
import app.thdev.databinding.ItemTextViewBinding
import tech.thdev.simpleadapter.SimpleAdapter
import tech.thdev.simpleadapter.util.bindViewHolder

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SimpleAdapterSampleFirstFragment : Fragment() {

    private lateinit var binding: AdapterSampleFragmentBinding

    private val simpleAdapter: SimpleAdapter by lazy {
        SimpleAdapter {
            when (viewType) {
                1 -> bindViewHolder<ItemTextViewBinding, Long>(
                    ItemTextViewBinding.inflate(layoutInflater, parent, false)
                ) { item ->
                    root.setOnClickListener {
                        Toast.makeText(requireContext(), "show Index $item", Toast.LENGTH_SHORT)
                            .show()
                    }
                    textView.text = "Use inflate $item"
                }
                else -> bindViewHolder<ItemTextViewBinding, Long> {
                    textView.text = "User reflection $it"
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return AdapterSampleFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.recyclerView.run {
            this.adapter = simpleAdapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }
        (0..100).forEach {
            simpleAdapter.addItem(it % 2, it)
        }
    }
}