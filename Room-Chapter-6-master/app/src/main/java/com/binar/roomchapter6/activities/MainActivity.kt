package com.binar.roomchapter6.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.roomchapter6.R
import com.binar.roomchapter6.StudentAdapter
import com.binar.roomchapter6.room.StudentDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private var mDB : StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mDB = StudentDatabase.getInstance(this)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        fetchData()

        fabAdd.setOnClickListener {
            val keActivityAdd = Intent(this, AddActivity::class.java)
            startActivity(keActivityAdd)
        }
        checkThread()
    }

    private fun checkThread() {
        Log.d("TAG", "check Thread => ${Thread.currentThread().name}")
        Thread{
            Log.d("TAG", "check Thread => ${Thread.currentThread().name}")
            runOnUiThread {
                Log.d("TAG", "check Thread => ${Thread.currentThread().name}")
            }
        }.start()
        val executor = Executors.newSingleThreadExecutor()
        executor.execute {
            Thread.sleep(3000)
            val threadId=Thread.currentThread().name
            Log.i("TAG", "Iam thread $threadId")
            Log.i("TAG", "Task 2 Completed")
        }
        executor.execute {
            Thread.sleep(3000)
            val threadId=Thread.currentThread().name
            Log.i("TAG", "Iam thread $threadId")
            Log.i("TAG", "Task 1 Completed")
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData(){
        GlobalScope.launch {
            val listStudent = mDB?.studentDao()?.getAllStudent()

            runOnUiThread{
                listStudent?.let {
                    val adapter = StudentAdapter(it)
                    recyclerView.adapter = adapter
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        StudentDatabase.destroyInstance()
    }
}