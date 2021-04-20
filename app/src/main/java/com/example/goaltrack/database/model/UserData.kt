package com.example.goaltrack.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData (
    @PrimaryKey (autoGenerate = true) val userID : Int,
    val fName : String,
    val lName : String,
    val age : Int,
    val gender : String,
    val bDate : String
)