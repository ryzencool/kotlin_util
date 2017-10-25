package com.zmy.springboot.kotlin_pro.enity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {
    var firstName: String
    var lastName: String
    @Id
    var id: String

    constructor(firstName: String, lastName: String, id: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.id = id
    }

    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', id='$id')"
    }


}