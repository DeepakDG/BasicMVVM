package com.example.mvvmsample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arka.basicandroidmvvm.R
import com.arka.basicandroidmvvm.adapters.UsersAdapter
import com.arka.basicandroidmvvm.models.User
import com.arka.basicandroidmvvm.viewmodels.UserViewModel
import com.arka.basicandroidmvvm.viewmodelsfactories.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var listUsers: MutableList<User>
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_main)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        listUsers = mutableListOf<User>()
        adapter = UsersAdapter(this,
            listUsers
        )
        recyclerview.adapter = adapter

        val userViewModel = ViewModelProviders.of(this, UserViewModelFactory(this)).get(
            UserViewModel::class.java)
        userViewModel.getData().observe(this,object:Observer<ArrayList<User>>{
            override fun onChanged(t: ArrayList<User>?) {
                listUsers.clear()
                t?.let { listUsers.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })

    }
}
