package com.example.roomdatabase.repository

import com.example.roomdatabase.data.entity.Mahasiswa
<<<<<<< HEAD
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}

fun getAllMhs() : Flow<List<Mahasiswa>>
=======

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}
>>>>>>> 77c42de2b083ddbaac9238f69dc117a7af3d550a
