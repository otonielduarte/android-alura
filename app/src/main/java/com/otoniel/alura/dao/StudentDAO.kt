package com.otoniel.alura.dao

import com.otoniel.alura.model.Student
import java.util.ArrayList

class StudentDAO {
    private val nextStudentId: Int
        get() = listStudents.size + 1

    fun save(student: Student) {
        listStudents.add(Student(
            nextStudentId,
            student.nome,
            student.phone,
            student.email
        ))
    }

    fun edit(student: Student) {
        val indexStudent = getIndexStudentById(student.id)
        if (indexStudent != -1) {
            listStudents[indexStudent] = student
        }
    }

    fun delete(student: Student) {
        val index = getIndexStudentById(student.id)
        if (index != -1) {
            val studentFromList = listStudents[index]
            listStudents.remove(studentFromList)
        }
    }

    private fun getIndexStudentById(studentId: Int): Int {
        var studentIndex = -1
        for (mStudent in listStudents) {
            if (studentId == mStudent.id) {
                studentIndex = listStudents.indexOf(mStudent)
                break
            }
        }
        return studentIndex
    }

    val all: List<Student>
        get() = ArrayList(listStudents)

    companion object {
        private val listStudents: MutableList<Student> = ArrayList()
    }
}