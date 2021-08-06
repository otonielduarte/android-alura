package com.otoniel.alura.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.alura.R
import com.otoniel.alura.model.Student
import com.otoniel.alura.ui.view.FormStudentView

class FormStudentActivity : AppCompatActivity() {

    private var editTextName: EditText? = null
    private var editTextPhone: EditText? = null
    private var editTextEmail: EditText? = null

    private lateinit var student: Student
    private lateinit var formStudentView: FormStudentView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_student)

        formStudentView = FormStudentView(this@FormStudentActivity)
        bindFields()
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
            student = intent.getSerializableExtra(ConstantsActivities.KEY_STUDENT_EDIT) as Student;
            title = resources.getString(R.string.activity_form_student_edit)
            setFormValues(student)
        } else {
            title = resources.getString(R.string.activity_form_student_add)
            student = Student()
        }
    }

    private fun isEditMode() = intent.hasExtra(ConstantsActivities.KEY_STUDENT_EDIT)

    private fun bindFields() {
        editTextName = findViewById(R.id.activity_form_name)
        editTextPhone = findViewById(R.id.activity_form_phone)
        editTextEmail = findViewById(R.id.activity_form_email)
    }

    private fun setFormValues(student: Student) {
        editTextName!!.setText(student.nome)
        editTextPhone!!.setText(student.phone)
        editTextEmail!!.setText(student.email)
    }

    private fun handleClick() {
        setStudentWithFormValues()
        finish()
    }

    private fun setStudentWithFormValues() {
        val name = editTextName!!.text.toString()
        val phone = editTextPhone!!.text.toString()
        val email = editTextEmail!!.text.toString()

        student.email = email
        student.phone = phone
        student.nome = name

        if (isEditMode()) {
            formStudentView.update(student)
        } else {
            formStudentView.save(student)
        }
    }
}