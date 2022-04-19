package com.news.zybertime.JSON;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface jsonApi {

    @GET("view_in_room")
    Call<List<Post>> getPosts(
            @Query("userId") String userId
    );

    @POST("view_in_room")
    Call<Post> createUser(@Body Post post);

    @FormUrlEncoded
    @POST("view_in_room")
    Call<Post> createUser(
            @Field("userId") String userId,
            @Field("fullName") String fullName,
            @Field("phoneNum") String phoneNum,
            @Field("location") String location
    );

    @FormUrlEncoded
    @POST("view_in_room")
    Call<Post> createUser(@FieldMap Map<String, String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
