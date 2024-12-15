package com.example.roomdatabase.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.data.entity.Mahasiswa
import java.util.concurrent.Flow

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}

@Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
fun getAllMahasiswa () : Flow<List<Mahasiswa>>