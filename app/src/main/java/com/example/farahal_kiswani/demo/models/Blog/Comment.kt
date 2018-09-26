package com.example.farahal_kiswani.demo.models.Blog

data class Comment(
        val id: Int,
        val comment: String,
        val created_at: Int,
        val user: UserX,
        val can_delete: Boolean
)