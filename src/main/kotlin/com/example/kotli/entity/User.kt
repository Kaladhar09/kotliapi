package com.example.Kotli.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

//import java.persistence.*
//import java.validation.constraints.Email
//import java.validation.constraints.NotBlank


@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:Email
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val selectedCategory: String,

    @field:NotBlank
    val selectedCountry: String
)
