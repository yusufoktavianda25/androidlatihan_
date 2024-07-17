package binar.academy.mymvp

interface MainView {
    //method untuk menampilkan toast
    fun showMessage(message:String)

    //method untuk menampilkan data yang telah diproses oleh presenter
    fun showData(data:String)

    //method untuk clear edit text
    fun clearField()
}