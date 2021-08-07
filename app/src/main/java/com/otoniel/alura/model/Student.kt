package com.otoniel.alura.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
class Student : Serializable {
    @Ignore
    constructor(id: Int, nome: String, phone: String, email: String, lastName: String, createdAt: Date?) {
        this.id = id
        this.email = email
        this.name = nome
        this.phone = phone
        this.lastName = lastName
        this.createdAt = createdAt
    }

    constructor()

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""
    var phone: String = ""
    var email: String = ""
    var lastName: String = ""
    var createdAt: Date? = Calendar.getInstance().time

    val fullName: String
        get() {
            return name + lastName
        }

    override fun toString(): String {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                '}'
    }
}