package com.example.goaltrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.goaltrack.database.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    //creating the userViewModel
    private lateinit var mUserViewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setupActionBarWithNavController(findNavController(R.id.fragment3))

    }
    //Overriding the onoSupportNavigationUp so that when user presses back on taskbar, it goes back properly.
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment3)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}