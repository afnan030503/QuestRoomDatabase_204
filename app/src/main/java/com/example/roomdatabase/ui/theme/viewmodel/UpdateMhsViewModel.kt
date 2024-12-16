package com.example.roomdatabase.ui.theme.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.repository.RepositoryMhs


class UpdateMhsViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
) : ViewModel () {

    var updateUIState by mutableStateOf(MhsUIState())
    private set

            private val nim: String = checkNotNull (savedStateHandle[DestinasiEdit.NIM])

    init {