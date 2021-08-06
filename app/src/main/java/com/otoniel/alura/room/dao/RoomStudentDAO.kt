package com.otoniel.alura.room.dao

import androidx.room.*
import com.otoniel.alura.model.Student

@Dao
interface RoomStudentDAO {
    @Query("SELECT * FROM student")
    fun getAll(): List<Student>


    @Query("SELECT * FROM student WHERE id IN (:studentIds)")
    fun loadAllByIds(studentIds: IntArray): List<Student>

    @Query("SELECT * FROM student WHERE nome LIKE :name LIMIT 1")
    fun findByName(name: String): Student

    @Update
    fun update(student: Student)

    @Insert
    fun save(student: Student)

    @Delete
    fun delete(student: Student)
}