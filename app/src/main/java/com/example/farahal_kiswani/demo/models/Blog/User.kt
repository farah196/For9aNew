package com.example.farahal_kiswani.demo.models.Blog

data class User(
        val id: Int,
        val first_name: String,
        val last_name: String,
        val email: String,
        val status: Int,
        val pic: String,
        val show_steps: Int,
        val gender: Any,
        val organization: Organization
)