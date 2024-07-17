package binar.academy.mymvp

import android.text.TextUtils
import binar.academy.mymvp.model.Student

class MainPresenterImp(private val view:MainView):MainPresenter {
    //sebuah arraylist utk menampung data
    private val STUDENT = mutableListOf<Student>()
    //override method add data yg ada pada interface presenter
    override fun addData(firstName: String, lastName: String) {
        if (TextUtils.isEmpty(firstName)||TextUtils.isEmpty(lastName)){
            //memanggil view utk menampilkan pesan saat salah satu dari edittext kosong
        }else{
            //menambahkan 2 value pada MutableList
            STUDENT.run{
                add(Student(firstName, lastName))
            }
        }
        //memanggil view untuk menapilkan pesan saat data ditambhakan
        view.showMessage("Data ditambahkan")

        //memanggil view utk clear edittext
        view.clearField()
    }

    //override method load data yang ada pada interface presenter
    override fun loadData() {
        if (STUDENT.size == 0){
            //memangil view untuk menampilkan pesan saat data pada arrayList masih kosong
            view.showMessage("Data masih kosong")
        }else{
            //sebuah variabel string dengan nama allData
            var allData = ""
            //melakukan for loop untuk mengisi sebuah variabel allData dengan setiap value yang ada pada arrayList
            for (i in 0 until STUDENT.size){
                allData += "Nama Depan : " + STUDENT[i].firstName + "\nNama Belakang : " + STUDENT[i].lastName +"\n\n"
            }
            //menampilkan jualan value yang ada pada arrayList
            allData += "Total : " +STUDENT.size
            //memanggil view untuk menampilkan data
            view.showData(allData)
        }
    }
}