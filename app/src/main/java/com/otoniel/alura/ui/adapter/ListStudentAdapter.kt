package com.otoniel.alura.ui.adapter

import android.content.Context
import android.util.Log
import android.widget.BaseAdapter
import com.otoniel.alura.model.Student
import android.view.ViewGroup
import android.widget.TextView
import com.otoniel.alura.R
import android.view.LayoutInflater
import android.view.View

class ListStudentAdapter(private val context: Context, private var students: ArrayList<Student>) : BaseAdapter() {

    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): Student {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return students[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        Log.i("DEBUG", "position $position")
        val inflated = getViewInflatedView(parent)
        val student = getItem(position)
        bindFields(inflated, student)
        return inflated
    }

    private fun bindFields(inflated: View, student: Student) {
        val txtName = inflated.findViewById<TextView>(R.id.studentName)
        val txtPhone = inflated.findViewById<TextView>(R.id.studentPhone)
        txtName.text = student.nome
        txtPhone.text = student.phone
    }

    private fun getViewInflatedView(parent: ViewGroup?): View {
        return LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.item_student, parent, false)
    }

    fun update(students: List<Student>) {
        this.students.clear()
        this.students.addAll(students)
        notifyDataSetChanged()
    }

    fun remove(student: Student) {
        students.remove(student)
        notifyDataSetChanged()
    }
}