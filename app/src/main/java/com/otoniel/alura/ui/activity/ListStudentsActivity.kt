package com.otoniel.alura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.otoniel.alura.R
import com.otoniel.alura.model.Student
import android.widget.AdapterView.OnItemClickListener
import com.otoniel.alura.ui.view.StudentListView
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.widget.AdapterView.AdapterContextMenuInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class ListStudentsActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var studentListView: StudentListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_students)
        title = resources.getString(R.string.acitivy_list_student_button)

        studentListView = StudentListView(this@ListStudentsActivity)

        createListView()
        handleFabButton()
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.activity_student_list_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val itemMenuId = item.itemId
        val menuInfo = item.menuInfo as AdapterContextMenuInfo
        val student = studentListView.getStudent(menuInfo.position)

        if (itemMenuId == R.id.activity_student_list_menu_remove) {
            studentListView.showDialogRemove(student)

        } else if (itemMenuId == R.id.activity_student_list_menu_edit) {
            initFormActivityEdit(student)
        }
        return super.onContextItemSelected(item)
    }

    private fun handleFabButton() {
        val actionButton = findViewById<FloatingActionButton>(R.id.list_student_activity_fab_add)
        actionButton.setOnClickListener { v: View? -> initFormActivity() }
    }

    private fun initFormActivity() {
        startActivity(
            Intent(this, FormStudentActivity::class.java)
        )
    }

    private fun initFormActivityEdit(student: Student) {
        val formActivity = Intent(this, FormStudentActivity::class.java)
        formActivity.putExtra(ConstantsActivities.Companion.KEY_STUDENT_EDIT, student)
        startActivity(formActivity)
    }

    override fun onResume() {
        super.onResume()
        studentListView.refreshAdapter()
    }

    private fun createListView() {
        val listView = findViewById<ListView>(R.id.activity_list_student_listview)
        listView.adapter = studentListView.adapterView
        listView.onItemClickListener = this
        registerForContextMenu(listView)
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val student = parent.getItemAtPosition(position) as Student
        initFormActivityEdit(student)
    }
}