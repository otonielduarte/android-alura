package com.otoniel.alura.ui.view;

import com.otoniel.alura.dao.StudentDAO;
import com.otoniel.alura.model.Student;

public class FormStudentView {

    private final StudentDAO dao;
    private Student student;


    public void setStudent(Student student) {
        this.student = student;
    }

    public FormStudentView() {
        this.dao = new StudentDAO();
    }

    public Student getStudent() {
        return student;
    }

    public void save() {
        if (student.getId() == 0) {
            dao.save(student);
        } else {
            dao.edit(student);
        }
    }
}
