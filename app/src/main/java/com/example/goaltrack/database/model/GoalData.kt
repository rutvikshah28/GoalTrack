package com.example.goaltrack.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class GoalData (
    @PrimaryKey(autoGenerate = true) val goalID : Int,
    val goalTitle : String,
    val goalDesc : String,
    val goalDate : String
        ) : Parcelable