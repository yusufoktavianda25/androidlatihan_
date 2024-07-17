package binar.academy.mymvp

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import binar.academy.mymvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView  {
    private lateinit var binding : ActivityMainBinding
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init presenter
        presenter = MainPresenterImp(this)
        binding.btnAdd.setOnClickListener{
            //memanggil method addData pada presenter
            presenter.addData(binding.FirstName.text.toString(), binding.LastName.text.toString())
        }
        binding.btnShow.setOnClickListener {
            //memanggil method loadData pada presenter
            presenter.loadData()
        }
    }

    //view menampilkan pesan toast
    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    //view menampilkan data
    override fun showData(data: String) {
        AlertDialog.Builder(this)
            .setTitle("Data")
            .setMessage(data)
            .setPositiveButton("Close",DialogInterface.OnClickListener {
                    dialogInterface, _ ->
                dialogInterface.dismiss()
            })
            .show()
    }

    //view untuk clear edittext
    override fun clearField() {
        binding.FirstName.setText("")
        binding.LastName.setText("")
    }
}