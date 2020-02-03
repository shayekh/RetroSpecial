package com.shayekh.android.retrospecial;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.postListRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData()
    {
        final Call<PostList> postList = BloggerApi.getService().getPostList();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list=response.body();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                PostAdapter adapter = new PostAdapter(MainActivity.this, list.getItems());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();



            }
        });
    }
}
