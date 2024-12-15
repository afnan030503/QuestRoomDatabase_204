package com.example.roomdatabase.ui.theme.navigation

interface AlamatNavigasi {
    val route: String
<<<<<<< HEAD
}

object DestinasiHome : AlamatNavigasi {
    override val route = "Home"
}

object DestinasiDetail : AlamatNavigasi{
    override val route = "Detail"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
}
object DestinasiUpdate : AlamatNavigasi {
    override val route = "update"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}}"
=======
>>>>>>> 77c42de2b083ddbaac9238f69dc117a7af3d550a
}