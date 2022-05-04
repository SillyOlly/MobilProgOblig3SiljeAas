package com.example.oblig3fotoalbummobilprog22aas

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.oblig3fotoalbummobilprog22aas.network.Users
import com.example.oblig3fotoalbummobilprog22aas.user.UserAdapter

@BindingAdapter("listUsers")
fun bindUserView(recyclerView: RecyclerView, data: List<Users>?) {
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(data)
}