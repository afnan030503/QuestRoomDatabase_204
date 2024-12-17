package com.example.roomdatabase.ui.theme.view.mahasiswa

import PenyediaViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdatabase.ui.theme.viewmodel.UpdateMhsViewModel

@Composable
fun UpdateMhsView(
    onBack: () -> Unit,
    OnNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}