package com.example.goaltrack.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//We make a parcelable goal dataclass and make it an entity
@Parcelize
@Entity
data class GoalData (
    @PrimaryKey(autoGenerate = true) val goalID : Int,
    val goalTitle : String,
    val goalDesc : String,
    val goalDate : String
        ) : Parcelable