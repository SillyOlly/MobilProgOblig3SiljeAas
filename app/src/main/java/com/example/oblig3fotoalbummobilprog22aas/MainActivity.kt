package com.example.oblig3fotoalbummobilprog22aas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().commit()

        // Configure navcontroller
        val navHostFrament =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFrament.navController

        // Configure toolbar
//        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.userFragment))
//        val toolbar: Toolbar = findViewById(R.id.nav_host_fragment)
//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        NavigationUI.setupWithNavController(toolbar, navController)

    }
}