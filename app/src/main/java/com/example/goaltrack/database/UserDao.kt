package com.example.goaltrack.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.model.UserData

//Creating the Dao for our user
@Dao
interface UserDao {
    //Functions for the database are defined in our UserDao interface

    //Function to get all the users -- We should technically only have one user in our application if we implement the first_time_setup correctly.
    @Query("select * from UserData order by userID asc")
    fun getUser() : LiveData<List<UserData>>
    //If there are no users, we want to insert a user into the UserData table
    @Insert
    suspend fun insertUser(user: UserData)

    //Function to get all the goals in our database
    @Query("select * from GoalData order by goalID asc")
    fun getGoals() : LiveData<List<GoalData>>
    //Function to insert a goal into our database
    @Insert
    suspend fun insertGoal(goal: GoalData)
    //Function to update a goal into the database
    @Update
    suspend fun updateGoal(goal: GoalData)
    //Function to delete a goal from the database
    @Delete
    suspend fun deleteGoal(goal: GoalData)


}