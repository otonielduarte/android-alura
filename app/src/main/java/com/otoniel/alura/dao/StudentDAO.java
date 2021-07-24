package com.otoniel.alura.dao;

import com.otoniel.alura.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> listStudents = new ArrayList<>();

    private int getNextStudentId() {
        return listStudents.size() + 1;
    }

    public void save(Student student) {
        listStudents.add(new Student(
                getNextStudentId(),
                student.getNome(),
                student.getPhone(),
                student.getEmail()
        ));
    }

    public void edit(Student student) {
        int indexStudent = getIndexStudentById(student.getId());
        if (indexStudent != -1) {
            listStudents.set(indexStudent, student);
        }
    }

    public void delete(Student student) {
        final int index = getIndexStudentById(student.getId());
        if (index != -1) {
            final Student studentFromList = listStudents.get(index);
            listStudents.remove(studentFromList);
        }
    }

    private int getIndexStudentById(int studentId) {
        int studentIndex = -1;
        for (Student mStudent : listStudents) {
            if (studentId == mStudent.getId()) {
                studentIndex = listStudents.indexOf(mStudent);
                break;
            }
        }
        return studentIndex;
    }

    public List<Student> getAll() {
        return new ArrayList<>(listStudents);
    }
}
