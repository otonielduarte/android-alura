package com.otoniel.alura.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.otoniel.alura.model.Student
import com.otoniel.alura.room.dao.RoomStudentDAO
import com.otoniel.alura.ui.activity.ConstantsActivities
import java.util.ArrayList

@Database(entities = [Student::class], version = 1)
abstract class StudentRoom : RoomDatabase() {
    abstract fun getRoomStudentDAO(): RoomStudentDAO

    companion object {
        fun getInstance(context: Context): StudentRoom = Room.databaseBuilder(context, StudentRoom::class.java, ConstantsActivities.ROOM_NAME)
            .allowMainThreadQueries()
            .build()
    }
}