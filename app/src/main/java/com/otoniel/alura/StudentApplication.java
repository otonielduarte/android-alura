package com.otoniel.alura;

import android.app.Application;

import com.otoniel.alura.dao.StudentDAO;
import com.otoniel.alura.model.Student;

public class StudentApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initValues();
    }

    private void initValues() {
        StudentDAO dao = new StudentDAO();
        dao.save(new Student(0, "Otoniel", "19991760932", "otoniel@gmail.com"));
        dao.save(new Student(0, "Bruna", "19991760932", "bruna@gmail.com"));
        dao.save(new Student(0, "Maria", "19991760932", "marialuisa@gmail.com"));
    }
}
