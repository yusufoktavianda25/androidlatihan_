package binar.academy.roomsample.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import binar.academy.roomsample.AddFragment
import binar.academy.roomsample.R
import binar.academy.roomsample.databinding.ItemUserBinding

class StudentAdapter(
    private val listStudent: List<Student>
    ) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(val itemView : View) :RecyclerView.ViewHolder(itemView) {
        private val binding = ItemUserBinding.bind(itemView)
        fun binding(profile: Student) {
            binding.tvID.text = profile.id.toString()
            binding.tvNama.text = profile.nama
            binding.tvEmail.text = profile.email
//            binding.btnEdit.setOnClickListener {
//                val studentParce =
//               it.findNavController()
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
//        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile: Student = listStudent[position]
        holder.binding(profile)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }
}