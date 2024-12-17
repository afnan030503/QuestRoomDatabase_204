package com.example.roomdatabase

import android.app.Application
import com.example.roomdatabase.dependeciesinjection.ContainerApp
import com.example.roomdatabase.dependeciesinjection.InterfaceContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp//fungsinya untuk menyimpan

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)//membuat instance
        //instance adalah objek yang dibuat dari class
    }
}
