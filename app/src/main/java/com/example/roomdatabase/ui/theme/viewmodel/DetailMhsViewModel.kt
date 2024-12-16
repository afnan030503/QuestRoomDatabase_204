package com.example.roomdatabase.ui.theme.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.repository.LocalRepositoryMhs
import com.example.roomdatabase.repository.RepositoryMhs
import com.example.roomdatabase.ui.theme.navigation.AlamatNavigasi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

data class DetailUiState(
)

class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs,
) : ViewModel() {
    private val _nim: String = checkNotNull(savedStateHandle[AlamatNavigasi.DestinasiDetail.NIM])

    val detailUiState: StateFlow<DetailUiState> = repositoryMhs.getMhs(_nim)
        .filterNotNull()
        .map {
            DetailUiEvent = it.toDetailEvent
        }
}