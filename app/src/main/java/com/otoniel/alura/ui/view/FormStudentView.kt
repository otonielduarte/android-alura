package com.otoniel.alura.ui.view

import android.content.Context
import com.otoniel.alura.model.Student
import com.otoniel.alura.room.StudentRoom
import com.otoniel.alura.room.dao.RoomStudentDAO


class FormStudentView(context: Context) {
    private val dao: RoomStudentDAO = StudentRoom.getInstance(context).getRoomStudentDAO()

    fun update(student: Student) {
        dao.update(student)
    }

    fun save(student: Student) {
        dao.save(student)
    }
}