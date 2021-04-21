package com.example.goaltrack.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.goaltrack.database.UserDatabase
import com.example.goaltrack.database.repository.UserRepository
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//This will be our main ViewModel that communicates between the repository and the ui.
class UserViewModel(application: Application) : AndroidViewModel(application) {
    //creating the read values for all tables
    val readUsers: LiveData<List<UserData>>
    val readGoals: LiveData<List<GoalData>>
    //Creating the repository
    private val repository : UserRepository

    //Init will always run first to initialize the content
    init {
        //Getting the database instance userDao into our userDao
        val userDao = UserDatabase.getDatabase(application).userDao()
        //Initializing the repository
        repository = UserRepository(userDao)
        //Once done, we access the read values from the repository to initialize the Users, Goals and Quotes
        readUsers = repository.readUsers
        readGoals = repository.readGoals

    }
    //Function to read the users
    fun readUsers() : LiveData<List<UserData>>{
        return repository.readUsers()
    }
    //Function to read the goals
    fun readGoals() : LiveData<List<GoalData>>{
        return repository.readGoals()
    }
    //Now we create the functions to insert the users, goals and quotes

    //Function to insert a user
    fun insertUser(user: UserData){
        //Using the kotlin coroutines to perform this action since we dont want to do database access from main ui thread. Dispatchers.IO ensures the code inside
        //is run from a background thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }
    }

    //Function to insert a goal
    fun insertGoal(goal: GoalData){
        //Using the kotlin coroutines to perform this action since we dont want to do database access from main ui thread. Dispatchers.IO ensures the code inside
        //is run from a background thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertGoal(goal)
        }
    }

    //Function to update a goal
    fun updateGoal(goal: GoalData){
        //Using the kotlin coroutines to perform this action since we dont want to do database access from main ui thread. Dispatchers.IO ensures the code inside
        //is run from a background thread
        viewModelScope.launch(Dispatchers.IO){
            repository.updateGoal(goal)
        }
    }

    //Function to delete a goal
    fun deleteGoal(goal:GoalData){
        //Using the kotlin coroutines to perform this action since we dont want to do database access from main ui thread. Dispatchers.IO ensures the code inside
        //is run from a background thread
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteGoal(goal)
        }
    }

}