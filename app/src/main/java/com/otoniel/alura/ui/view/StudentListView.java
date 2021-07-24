package com.otoniel.alura.ui.view;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.otoniel.alura.dao.StudentDAO;
import com.otoniel.alura.model.Student;
import com.otoniel.alura.ui.adapter.ListStudentAdapter;

public class StudentListView {

    private final StudentDAO dao;
    private final ListStudentAdapter adapterView;
    private final Context context;

    public StudentListView(Context context) {
        this.context = context;
        this.adapterView = new ListStudentAdapter(context);
        this.dao = new StudentDAO();
    }

    public void refreshAdapter() {
        adapterView.update(dao.getAll());
    }

    public void showDialogRemove(final Student studentRemove) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removing Student")
                .setMessage("Would you like to remove the student " + studentRemove.getNome() + "?")
                .setPositiveButton("Yes", (dialog, which) -> removeStudent(studentRemove))
                .setNegativeButton("No", null)
                .show();
    }

    public Student getStudent(int position) {
        return adapterView.getItem(position);
    }

    public ListStudentAdapter getAdapterView() {
        return adapterView;
    }

    private void removeStudent(Student student) {
        dao.delete(student);
        adapterView.remove(student);
    }
}
