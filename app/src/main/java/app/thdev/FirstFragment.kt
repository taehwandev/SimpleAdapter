package app.thdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import app.thdev.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.item_text_view.view.*
import tech.thdev.simpleadapter.SimpleRecyclerViewAdapter
import tech.thdev.simpleadapter.bindViewHolder

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val adapter: SimpleRecyclerViewAdapter by lazy {
        SimpleRecyclerViewAdapter { _ ->
            bindViewHolder<Int>(R.layout.item_text_view) { item ->
                text_view.text = "Index $item"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentFirstBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.recyclerView.run {
            this.adapter = this@FirstFragment.adapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }
        (0..100).forEach {
            adapter.addItem(0, it)
        }
    }
}