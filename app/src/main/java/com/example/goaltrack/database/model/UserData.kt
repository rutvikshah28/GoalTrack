package com.example.goaltrack.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//We make a dataclass for Users and also make it an entity for our room database and userdao.
@Entity
data class UserData (
    @PrimaryKey (autoGenerate = true) val userID : Int,
    val fName : String,
    val lName : String,
    val age : Int,
    val gender : String,
    val bDate : String
)