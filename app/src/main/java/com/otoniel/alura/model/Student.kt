package com.otoniel.alura.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Student : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var nome: String? = null
    var phone: String? = null
    var email: String? = null

    @Ignore
    constructor(id: Int, nome: String?, phone: String?, email: String?) {
        this.id = id
        this.email = email
        this.nome = nome
        this.phone = phone
    }

    constructor() {}

    override fun toString(): String {
        return "Student{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}'
    }
}