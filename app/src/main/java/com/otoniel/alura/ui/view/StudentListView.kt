package com.otoniel.alura.ui.view

import android.content.Context
import com.otoniel.alura.model.Student
import com.otoniel.alura.ui.adapter.ListStudentAdapter
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.otoniel.alura.room.StudentRoom
import com.otoniel.alura.ui.activity.ConstantsActivities

class StudentListView(private val context: Context) {

    private var dao = StudentRoom.getInstance(context).getRoomStudentDAO()

    val adapterView = ListStudentAdapter(context, ArrayList(dao.getAll()))

    fun refreshAdapter() {
        adapterView.update(dao.getAll())
    }

    fun showDialogRemove(studentRemove: Student) {
        AlertDialog.Builder(context)
            .setTitle("Removing Student")
            .setMessage("Would you like to remove the student " + studentRemove.nome + "?")
            .setPositiveButton("Yes") { _: DialogInterface?, _: Int ->
                removeStudent(studentRemove)
            }
            .setNegativeButton("No", null)
            .show()
    }

    fun getStudent(position: Int): Student {
        return adapterView.getItem(position)
    }

    private fun removeStudent(student: Student) {
        dao.delete(student)
        adapterView.remove(student)
    }
}