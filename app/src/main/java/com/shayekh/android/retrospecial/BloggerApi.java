package com.shayekh.android.retrospecial;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerApi {
    private static final String key="AIzaSyA0Al6EPnpStx_LjJ0leqXvAE62ZM5_Q6I";
    private static final String BASE_URL="https://www.googleapis.com/blogger/v3/blogs/3817523513002433752/posts/";

    public static PostService postService=null;

    public static PostService getService(){
        if(postService==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            postService = retrofit.create(PostService.class);

        }



        return postService;

    }



    public interface PostService{
        @GET("?key="+key)
        Call<PostList>getPostList();
    }

}
