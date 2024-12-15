package com.example.roomdatabase.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.roomdatabase.data.entity.Mahasiswa
import com.example.roomdatabase.repository.RepositoryMhs
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState(
    val listMhs : List<Mahasiswa> = listOf(),
    val listLoading : Boolean = false,
    val isError : Boolean = false,
    val errorMesaage : String = ""
)

class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {
    val homeUIState : StateFlow<HomeUiState> = repositoryMhs.getAllMhs()
}