package com.example.movietmdbchallenge.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listmoview.room.User
import com.example.movietmdbchallenge.data.local.UserRepository
import java.lang.RuntimeException


class ViewModelFactory(private val context: Context):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            return modelClass.getConstructor(UserRepository::class.java)
                .newInstance(UserRepository.getInstance(context))
        } catch (e:InstantiationException){
            throw RuntimeException("Cannot create an instance of $modelClass",e)
        } catch (e: IllegalAccessException){
            throw RuntimeException("Cannot create an instance of $modelClass",e)
        }
    }
}