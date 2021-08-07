package com.otoniel.alura.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.alura.R
import com.otoniel.alura.model.Student
import com.otoniel.alura.ui.view.FormStudentView
import kotlinx.android.synthetic.main.activity_form_student.*

class FormStudentActivity : AppCompatActivity() {

    private lateinit var student: Student
    private lateinit var formStudentView: FormStudentView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_student)

        formStudentView = FormStudentView(this@FormStudentActivity)
        handleFormType()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_student_form_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val index = item.itemId
        if (index == R.id.activity_student_form_menu_save) {
            handleClick()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun handleFormType() {
        if (isEditMode()) {
            student = intent.getSerializableExtra(ConstantsActivities.KEY_STUDENT_EDIT) as Student
            title = resources.getString(R.string.activity_form_student_edit)
            setFormValues(student)
        } else {
            title = resources.getString(R.string.activity_form_student_add)
            student = Student()
        }
    }

    private fun isEditMode() = intent.hasExtra(ConstantsActivities.KEY_STUDENT_EDIT)

    private fun setFormValues(student: Student) {
        formFirstName.setText(student.name)
        formPhone.setText(student.phone)
        formEmail.setText(student.email)
        formLastName.setText(student.lastName)
    }

    private fun handleClick() {
        setStudentWithFormValues()
        handleSave()
        finish()
    }

    private fun setStudentWithFormValues() {
        student.email = formEmail.text.toString()
        student.phone = formPhone.text.toString()
        student.name = formFirstName.text.toString()
        student.lastName = formLastName.text.toString()
    }

    private fun handleSave() {
        if (isEditMode()) {
            formStudentView.update(student)
        } else {
            formStudentView.save(student)
        }
    }
}