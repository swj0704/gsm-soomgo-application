package com.example.gsmgosu.retrofit.api

import com.example.gsmgosu.retrofit.data.Message
import com.example.gsmgosu.retrofit.data.user.Token
import com.example.gsmgosu.retrofit.data.user.UserInfo
import retrofit2.Call
import retrofit2.http.*

interface UserAPI {
    @GET("user")
    fun getUserInfo(
        @Query("access_token") access_token : String? = null
    ) : Call<UserInfo>

    @GET("users")
    fun getGradeInfo(
        @Query("gradeFilter") gradeFilter : String? = null
    ) : Call<List<UserInfo>>

    @FormUrlEncoded
    @POST("user")
    fun setUserInfo(
        @Field("email") email : String,
        @Field("name") name : String,
        @Field("image") image : String
    ) : Call<Token>
    @PATCH("user")
    fun patchUser(
        @Query("access_token") access_token: String,
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("image") image: String,
        @Field("grade") grade : Int,
        @Field("student_class") student_class : Int,
        @Field("student_number") student_number : Int,
        @Field("introduce") introduce : String
    ) : Call<Token>
    @DELETE("user")
    fun deleteUser(
        @Query("access_token") access_token: String
    ) : Call<Message>
}