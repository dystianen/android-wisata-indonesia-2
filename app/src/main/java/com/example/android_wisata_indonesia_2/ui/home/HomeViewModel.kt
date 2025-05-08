package com.example.android_wisata_indonesia_2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.android_wisata_indonesia_2.model.Wisata

class HomeViewModel : ViewModel() {

    private val _wisataList = MutableLiveData<List<Wisata>>()
    val wisataList: LiveData<List<Wisata>> get() = _wisataList

    private val currentList = mutableListOf(
        Wisata("Pantai Kuta", "Bali", "Pantai terkenal dengan pasir putih dan ombaknya."),
        Wisata("Candi Borobudur", "Jogja", "Candi Buddha terbesar di dunia."),
        Wisata("Gili Trawangan", "Lombok", "Pulau kecil dengan pantai indah dan snorkeling.")
    )

    init {
        _wisataList.value = currentList
    }

    fun addWisata(wisata: Wisata) {
        currentList.add(wisata)
        _wisataList.value = currentList.toList() // trigger update
    }
}
