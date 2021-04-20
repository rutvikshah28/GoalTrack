package com.example.goaltrack.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.model.UserData

@Database(version = 1, entities = [UserData::class, GoalData::class], exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    //Creating a function that returns our UserDao
    abstract fun userDao() : UserDao

    //Creating the companion object for our database
    companion object{
        //We want the database to implement the singleton design method, so we are able to create a single instance at a time to avoid database conflicts.
        @Volatile
        private var INSTANCE: UserDatabase? = null

        //Creating the getDatabase function
        fun getDatabase(context: Context) : UserDatabase{
            //Checking if there is an instance already active
            val checkInstance = INSTANCE
            if(checkInstance != null){
                //If there is already an instance, we return that
                return checkInstance
            }
            //If the instance is null, we create the database in a synchronized block to protect concurrent execution by multiple threads
            synchronized(this){
                val createInstance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "goaltrack_database").build()
                //After creating this instance, we assign it to our singleton instance and return the createInstance
                INSTANCE = createInstance
                return createInstance
            }
        }
    }


}