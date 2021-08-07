package com.otoniel.alura.room

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.otoniel.alura.model.Student
import com.otoniel.alura.room.converter.DaoConverters
import com.otoniel.alura.room.dao.RoomStudentDAO
import com.otoniel.alura.ui.activity.ConstantsActivities

@Database(entities = [Student::class], version = 4)
@TypeConverters(DaoConverters::class)
abstract class StudentRoom : RoomDatabase() {
    abstract fun getRoomStudentDAO(): RoomStudentDAO

    companion object {
        fun getInstance(context: Context): StudentRoom = Room.databaseBuilder(context, StudentRoom::class.java, ConstantsActivities.ROOM_NAME)
            .allowMainThreadQueries()
            .addMigrations(StudentMigrations(1, 2), StudentMigrations(2, 3), StudentMigrations(3, 4) )
            .build()
    }
}

private class StudentMigrations(startVersion: Int, endVersion: Int) : Migration(startVersion, endVersion) {
    override fun migrate(database: SupportSQLiteDatabase) {
        if(startVersion == 1 && endVersion == 2) {
            // Create new table with info
            database.execSQL("CREATE TABLE IF NOT EXISTS `Student_M` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `phone` TEXT NOT NULL, `email` TEXT NOT NULL)")
            // Copy old table values to new table
            database.execSQL("INSERT INTO Student_M (id, name, phone, email)" +
                    "SELECT id, name, phone, email FROM Student")
            // Remove old table
            database.execSQL("DROP TABLE Student")
            // Rename the new table for the correct name
            database.execSQL("ALTER TABLE Student_M RENAME TO Student")
        }
        else if(startVersion == 2 && endVersion == 3) {
            database.execSQL("ALTER TABLE Student ADD COLUMN lastName TEXT")
        }
        else if(startVersion == 3 && endVersion == 4) {
            database.execSQL("ALTER TABLE Student ADD COLUMN createdAt INTEGER")
        }
    }
}