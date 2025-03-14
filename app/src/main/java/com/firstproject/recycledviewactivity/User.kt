package com.firstproject.recycledviewactivity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val profileImage: Int,
    val name: String,
    val email: String,
    val age: Int
)