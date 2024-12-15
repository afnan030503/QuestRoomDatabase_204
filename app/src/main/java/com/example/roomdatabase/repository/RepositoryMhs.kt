package com.example.roomdatabase.repository

import com.example.roomdatabase.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}

fun getAllMhs() : Flow<List<Mahasiswa>>