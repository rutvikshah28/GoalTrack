package com.example.goaltrack.database.repository

import androidx.lifecycle.LiveData
import com.example.goaltrack.database.UserDao
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.model.UserData


//The repository class will basically add an abstraction layer to multiple data access sources
class UserRepository(private val userDao: UserDao) {

    //Reading the users table
    val readUsers : LiveData<List<UserData>> = userDao.getUser()
    fun readUsers() : LiveData<List<UserData>>{
        return userDao.getUser()
    }
    //Inserting into the users table
    suspend fun insertUser(user: UserData){
        userDao.insertUser(user)
    }

    //Reading the goals table
    val readGoals : LiveData<List<GoalData>> = userDao.getGoals()
    fun readGoals() : LiveData<List<GoalData>>{
        return userDao.getGoals()
    }
    //Inserting into the goals table
    suspend fun insertGoal(goal: GoalData){
        userDao.insertGoal(goal)
    }
    //Updating into the goals table
    suspend fun updateGoal(goal: GoalData){
        userDao.updateGoal(goal)
    }
    //Deleting from the goals table
    suspend fun deleteGoal(goal: GoalData){
        userDao.deleteGoal(goal)
    }
}