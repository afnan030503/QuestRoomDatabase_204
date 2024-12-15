package com.example.roomdatabase.data.dao

import androidx.room.Dao
<<<<<<< HEAD
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabase.data.entity.Mahasiswa
import java.util.concurrent.Flow
=======
import androidx.room.Insert
import com.example.roomdatabase.data.entity.Mahasiswa
>>>>>>> 77c42de2b083ddbaac9238f69dc117a7af3d550a

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
<<<<<<< HEAD
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>

}


=======
}
>>>>>>> 77c42de2b083ddbaac9238f69dc117a7af3d550a
