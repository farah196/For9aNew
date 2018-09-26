package com.example.farahal_kiswani.demo.models.Blog

data class Category(
        val id: Int,
        val title: String,
        val title_ar: String,
        val url: String,
        val slug: String,
        val slug_en: String,
        val order: Int,
        val h2: String
)