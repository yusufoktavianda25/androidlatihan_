package binar.academy.mydatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import binar.academy.mydatastore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var pref : CounterDataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = CounterDataStoreManager(this)
        viewModel=ViewModelProvider(this, ViewModelFactory(pref))[MainViewModel::class.java]

        setupView()
        setObserver()
    }

    private fun setObserver() {
        viewModel.apply {
            getDataStore().observe(this@MainActivity){
//                binding.tvValue.text=it.toString()
                viewModel.getValue(it)

            }
             vCount.observe(this@MainActivity){ result ->
                binding.tvValue.text= result.toString()

            }

        }
    }


    private fun setupView() {
        binding.apply{
            btnIncrease.setOnClickListener {
                incrementCount()
            }
            btnDecrease.setOnClickListener {
                decrementCount()
            }
            btnSet.setOnClickListener {
                viewModel.saveDataStore(binding.tvValue.text.toString().toInt())
            }
        }
    }

    private fun decrementCount() {
        viewModel.decrementCount()
    }

    private fun incrementCount() {
        viewModel.incrementCount()
    }


}