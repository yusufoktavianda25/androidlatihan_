package binar.academy.mymvp

interface MainPresenter {
    //method utk menambah data
    fun addData(firstName:String, lastName:String)

    //method utk memproses data
    fun loadData()
}