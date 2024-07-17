package binar.academy.roomexercise.data

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import binar.academy.roomexercise.HomeFragment
import binar.academy.roomexercise.R
import binar.academy.roomexercise.data.database.StudentDatabase
import binar.academy.roomexercise.databinding.StudentItemBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

@DelicateCoroutinesApi
class StudentAdapter(
    private val studentList: List<Student>
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemBinding = StudentItemBinding.bind(view)
        fun bindingItem(data: Student) {
            with(itemBinding) {
                tvID.text = data.id.toString()
                tvNama.text = data.name
                tvEmail.text = data.email
            }
        }
//        val ivDelete = view.findViewById<ImageView>(R.id.ivDelete)
        fun deleteItem(data:Student){
            itemBinding.ivDelete.setOnClickListener {
                AlertDialog.Builder(it.context).setPositiveButton("Ya") { _, _ ->
                    val mDb = StudentDatabase.getInstance(itemView.context)

                    GlobalScope.async {
                        val result = mDb?.studentDao()?.deleteStudent(data)

                        (itemView.context as HomeFragment).activity?.runOnUiThread {
                            if (result!=0){
                                Toast.makeText(it.context,"Data ${data.name} berhasil dihapus",
                                    Toast.LENGTH_LONG).show()
                            }else{
                                Toast.makeText(it.context,"Data ${data.name} Gagal dihapus",
                                    Toast.LENGTH_LONG).show()
                            }
                        }
                        (itemView.context as HomeFragment).fetchData()
                    }
                }.setNegativeButton("Tidak"
                ) { p0, _ ->
                    p0.dismiss()
                }
                    .setMessage("Apakah Anda Yakin ingin menghapus data ${data.name}").setTitle("Konfirmasi Hapus").create().show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = studentList[position]
        holder.bindingItem(data)
        holder.deleteItem(data)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}