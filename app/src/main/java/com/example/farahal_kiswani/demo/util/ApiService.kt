package com.example.farahal_kiswani.demo

import com.example.farahal_kiswani.demo.models.Blog.Blogs
import com.example.farahal_kiswani.demo.models.TimelineResponse2
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {


    @GET("/user/timeline")
    fun getTimeline(@Header("authentication") auth: String, @Query("count") count: Int?, @Query("since_id") since_id: Int?): retrofit2.Call<TimelineResponse2>


    @GET("/blog/posts/0")
    fun getBlog(@Header("authentication") auth: String, @Query("count") count: Int?): retrofit2.Call<List<Blogs>>

    @GET("/opportunity/search")
    fun getSearch(  @Query("count") count: Int?,@Query("since_id") rand: String?,@Query("term") term: String?): retrofit2.Call<TimelineResponse2>

}