package com.example.android_wisata_indonesia_2.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.android_wisata_indonesia_2.R
import com.example.android_wisata_indonesia_2.databinding.FragmentDetailWisataBinding
import com.example.android_wisata_indonesia_2.model.Wisata

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailWisataBinding? = null
    private val binding get() = _binding!!

    private var wisata: Wisata? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wisata = arguments?.getParcelable(ARG_WISATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailWisataBinding.inflate(inflater, container, false)
        wisata?.let {
            binding.tvName.text = it.name
            binding.tvLocation.text = it.location
            binding.tvDescription.text = it.description
        }

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_WISATA = "arg_wisata"

        fun newInstance(wisata: Wisata): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle().apply {
                putParcelable(ARG_WISATA, wisata)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
