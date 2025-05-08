package com.example.android_wisata_indonesia_2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_wisata_indonesia_2.databinding.FragmentHomeBinding
import com.example.android_wisata_indonesia_2.ui.detail.DetailFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var adapter: WisataAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        adapter = WisataAdapter(emptyList()) { wisata ->
            val fragment = DetailFragment.newInstance(wisata)
            parentFragmentManager.beginTransaction()
                .replace(
                    com.example.android_wisata_indonesia_2.R.id.fragment_container, fragment
                )
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe list of wisata from ViewModel
        viewModel.wisataList.observe(viewLifecycleOwner) { list ->
            adapter.updateData(list)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}