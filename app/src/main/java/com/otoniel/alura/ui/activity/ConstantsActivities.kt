package com.otoniel.alura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.otoniel.alura.ui.view.FormStudentView
import android.os.Bundle
import com.otoniel.alura.R
import com.otoniel.alura.model.Student
import com.otoniel.alura.ui.activity.ConstantsActivities
import android.widget.AdapterView.OnItemClickListener
import com.otoniel.alura.ui.view.StudentListView
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.widget.AdapterView.AdapterContextMenuInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent
import com.otoniel.alura.ui.activity.FormStudentActivity
import android.widget.AdapterView

interface ConstantsActivities {
    companion object {
        const val KEY_STUDENT_EDIT = "studentEdit"
        const val ROOM_NAME = "students.db"
    }
}