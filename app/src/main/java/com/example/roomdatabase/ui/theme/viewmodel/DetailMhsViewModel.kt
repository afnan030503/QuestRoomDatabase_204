package com.example.roomdatabase.ui.theme.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.repository.LocalRepositoryMhs
import com.example.roomdatabase.repository.RepositoryMhs
import com.example.roomdatabase.ui.theme.navigation.AlamatNavigasi

class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs,
) : ViewModel() {
    private val nim: String = checkNotNull(savedStateHandle[AlamatNavigasi.DestinasiDetail.NIM])
}