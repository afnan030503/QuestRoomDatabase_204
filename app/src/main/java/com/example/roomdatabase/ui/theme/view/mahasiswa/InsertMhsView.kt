package com.example.roomdatabase.ui.theme.view.mahasiswa

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monitoringapplication.ui.costumwidget.cmTopAppBar
import com.example.roomdatabase.ui.theme.navigation.AlamatNavigasi
import com.example.roomdatabase.ui.theme.viewmodel.FormErrorState
import com.example.roomdatabase.ui.theme.viewmodel.MahasiswaEvent
import com.example.roomdatabase.ui.theme.viewmodel.MahasiswaViewModel
import com.example.roomdatabase.ui.theme.viewmodel.MhsUIState
import com.example.roomdatabase.ui.theme.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiInsert : AlamatNavigasi{
    override val route : String = "Insert_mhs"
}

@Composable
fun InsertBodyMhs(
    modifier: Modifier = Modifier,
    onValueChange: (MahasiswaEvent) -> Unit,
    uiState: MhsUIState,
    onClick : () -> Unit
){
    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        FormMahasiswa(
            mahasiswaEvent = uiState.mahasiswaEvent,
            onValueChange = onValueChange,
            errorState = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Simpan")
        }
    }
}

object DestinasiInsert : AlamatNavigasi {
    override val route: String = "insert_mhs"
}

@Composable
fun InsertMhsView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier =Modifier,
    viewModel: MahasiswaViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiState = viewModel.uiState//ambil ui state dari view model
    val snackbarHostState = remember { SnackbarHostState()}
    val coroutineScope = rememberCoroutineScope()

    //observasi perubahan snackbarmessage
    LaunchedEffect(uiState.snackBarMessage) {
        uiState.snackBarMessage?.let { message->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message) // tampilkan snackbar
                viewModel.resetSnackBarMessage()
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            cmTopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Mahasiswa"
            )
                //isi body
            InsertBodyMhs(
                uiState = uiState,
                onValueChange = {updateEvent ->
                    viewModel.updateState(updateEvent) //update state di view model
                },
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveData()//simpan data
                    }
                    onNavigate()
                }
            )
        }
    }
}


@Composable
fun FormMahasiswa(
    mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    onValueChange: (MahasiswaEvent) -> Unit,
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
) {
    val jeniskelamin = listOf("Laki-Laki", "Perempuan")
    val kelas = listOf("A", "B", "C", "D", "E")

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nama,
            onValueChange = {
                onValueChange(mahasiswaEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.nama != null,
            placeholder = { Text("Masukkan Nama") },
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nim, onValueChange = {
                onValueChange(mahasiswaEvent.copy(nim = it))
            },
            label = { Text("NIM") },
            isError = errorState.nim != null,
            placeholder = { Text("Masukkan Nim") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = errorState.nim ?: "", color = Color.Red)

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Jenis Kelamin")
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            jeniskelamin.forEach { jk ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RadioButton(
                        selected = mahasiswaEvent.jeniskelamin == jk,
                        onClick = {
                            onValueChange(mahasiswaEvent.copy(jeniskelamin = jk))
                        },
                    )
                    Text(
                        text = jk,

                        )

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = mahasiswaEvent.alamat,
                        onValueChange = {
                            onValueChange(mahasiswaEvent.copy(alamat = it))
                        },
                        label = { Text("alamat") },
                        isError = errorState.alamat != null,
                        placeholder = { Text("Masukkan alamat") },
                    )
                    Text(
                        text = errorState.alamat ?: "",
                        color = Color.Red
                    )
                    kelas.forEach { kelas ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            RadioButton(
                                selected = mahasiswaEvent.kelas == kelas,
                                onClick = {
                                    onValueChange(mahasiswaEvent.copy(kelas = jk))
                                },
                            )
                            Text(text = kelas)

                        }
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = mahasiswaEvent.angkatan, onValueChange = {
                                onValueChange(mahasiswaEvent.copy(nim = it))
                            },
                            label = { Text("angkatan") },
                            isError = errorState.nim != null,
                            placeholder = { Text("Masukkan angkatan") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        Text(text = errorState.angkatan ?: "", color = Color.Red)

                    }
                }
            }
        }
    }
}