package com.example.farahal_kiswani.demo.models.Blog

data class Blogs (
    val id:Int,
    val title:String,
    val html_body:String,
    val video_url:Any,
    val image:String,
    val image_list:String,
    val mail_image:String,
    val category:Category,
    val user:User,
    val created_at:Int,
    val comments_count:String,
    val slug:String,
    val slug_en:String,
    val users:List<Any>,
    val body:String,
    val url:String,
    val comments:List<Comment>
)