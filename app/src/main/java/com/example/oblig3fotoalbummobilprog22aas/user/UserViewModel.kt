package com.example.oblig3fotoalbummobilprog22aas.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oblig3fotoalbummobilprog22aas.network.RetrofitInstance
import com.example.oblig3fotoalbummobilprog22aas.network.TestApi
import com.example.oblig3fotoalbummobilprog22aas.network.Users
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import androidx.lifecycle.*
import com.example.oblig3fotoalbummobilprog22aas.user.UserAdapter

class UserViewModel : ViewModel() {

    private val _users = MutableLiveData<List<Users>>()
    private lateinit var userAdapter: UserAdapter

    val users: MutableLiveData<List<Users>>
        get() = _users

    init {
        getUsers()
        Log.d("EIRIK", "GETUSER")
    }

    private fun getUsers() {
        Log.d("EIRIK", "GETUSERACTUAL111")

        viewModelScope.launch {
            try {
                _users.value = RetrofitInstance.api.getUsers()
//                userAdapter.users = RetrofitInstance.api.getUsers()
//                _users.value = TestApi.retrofitService.getUsers()
                println("TEST")
                println(_users.value)
                Log.d("EIRIK", "GETUSERACTUAL")
            } catch (e: Exception) {
                Log.d("EIRIK", "FAILLLL")
                Log.e("EIRIK", e.message.toString())
                println("EXCEPTION WHEN running Api.retrofitService.getUsers()")
                println(e)
            }
        }

    }
}

