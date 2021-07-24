package com.otoniel.alura.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.otoniel.alura.R;
import com.otoniel.alura.model.Student;

import java.util.ArrayList;
import java.util.List;


public class ListStudentAdapter extends BaseAdapter {

    private final List<Student> students = new ArrayList<>();
    private final Context context;

    public ListStudentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.students.size();
    }

    @Override
    public Student getItem(int position) {
        return this.students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.students.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflated = getView(parent);
        Student student = getItem(position);
        bindFields(inflated, student);
        return inflated;
    }

    private void bindFields(View inflated, Student student) {
        TextView txtName = inflated.findViewById(R.id.item_student_name);
        TextView txtPhone = inflated.findViewById(R.id.item_student_phone);
        txtName.setText(student.getNome());
        txtPhone.setText((student.getPhone()));
    }

    private View getView(ViewGroup parent) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_student, parent, false);
    }

    public void update(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    public void remove(Student student) {
        students.remove(student);
        notifyDataSetChanged();
    }
}
