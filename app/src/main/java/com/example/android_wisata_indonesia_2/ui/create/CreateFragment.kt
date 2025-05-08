package com.example.android_wisata_indonesia_2.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_wisata_indonesia_2.MainActivity
import com.example.android_wisata_indonesia_2.R
import com.example.android_wisata_indonesia_2.databinding.FragmentCreateBinding
import com.example.android_wisata_indonesia_2.model.Wisata
import com.example.android_wisata_indonesia_2.ui.home.HomeFragment
import com.example.android_wisata_indonesia_2.ui.home.HomeViewModel

class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    // Shared ViewModel
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.buttonSimpan.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val location = binding.editTextLocation.text.toString().trim()
            val description = binding.editTextDeskripsi.text.toString().trim()

            if (name.isEmpty() || location.isEmpty() || description.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                val newWisata = Wisata(name, location, description)
                viewModel.addWisata(newWisata)

                // Reset form
                binding.editTextName.text?.clear()
                binding.editTextLocation.text?.clear()
                binding.editTextDeskripsi.text?.clear()

                Toast.makeText(requireContext(), "Wisata berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()

                (requireActivity() as MainActivity).binding.navView.selectedItemId = R.id.navigation_home
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
