package com.otoniel.alura.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    final private int id;
    private String nome;
    private String phone;
    private String email;

    public Student(int id, String nome, String phone, String email) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.phone = phone;
    }

    public Student() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @NonNull
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
