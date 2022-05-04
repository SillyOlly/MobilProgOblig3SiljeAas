package com.example.oblig3fotoalbummobilprog22aas.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oblig3fotoalbummobilprog22aas.databinding.FragmentUserBinding
import retrofit2.HttpException
import java.io.IOException

class UserFragment : Fragment() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }
    lateinit var binding: FragmentUserBinding
    private lateinit var userAdapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.title = "Users"
        setHasOptionsMenu(true)

        binding = FragmentUserBinding.inflate(inflater)
        binding.lifecycleOwner = this
        setupRecycleView()
        binding.usersViewModel = userViewModel
        Log.d("EIRIK", "GÅRDEN INN HER?")
        userAdapter.users = userViewModel.users.value!!

        binding.userRecyclerView.adapter = UserAdapter()


//        userViewModel.users.observe(viewLifecycleOwner, Observer {
//            binding.userRecyclerView
//            Log.d("EIRIK", "OBSERVERRR")
//            Log.d("EIRIK", it.toString())
//        })
//
//        lifecycleScope.launchWhenCreated {
//            binding.progressBar.isVisible = true
//            binding.usersViewModel = userViewModel
//
//            binding.progressBar.isVisible = false
//        }
        Log.d("EIRIK", "FØRSTE!!!")
        println("USERESS")
        println(userViewModel)

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        println("USERESS22")
//        binding.usersViewModel = userViewModel
//
//        println(userViewModel.users.value)
//        Log.d("EIRIK", "VILHENTELIVEDATA")
//
//    }

    private fun setupRecycleView() = binding.userRecyclerView.apply {
        userAdapter = UserAdapter()
        adapter = userAdapter
        layoutManager = GridLayoutManager(this.context, 1)
    }
}