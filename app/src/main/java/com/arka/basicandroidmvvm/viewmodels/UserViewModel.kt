package com.arka.basicandroidmvvm.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arka.basicandroidmvvm.models.User
import com.arka.basicandroidmvvm.repositories.UserRepository
import com.arka.basicandroidmvvm.utils.Utility.isInternetAvailable

class UserViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<User>>()

    init{
        val userRepository : UserRepository by lazy {
            UserRepository
        }
        if(context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<ArrayList<User>>{
        return listData
    }

}