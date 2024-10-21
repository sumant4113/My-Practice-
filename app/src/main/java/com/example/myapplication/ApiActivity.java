package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.PostApiAdapter;
import com.example.myapplication.models.PostApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ApiActivity extends AppCompatActivity {

    private static final String TAG = "ApiActivity";
    private RecyclerView rvApi;
    private PostApiAdapter postApiAdapter;
//    private ArrayList<PostApi> postApiArrayListAPI = new ArrayList<>();
    private ArrayList<PostApi> postApiArrayListRV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        initView();
    }
    private void initView() {
        rvApi = findViewById(R.id.rv_api);

        postApiAdapter = new PostApiAdapter(ApiActivity.this, postApiArrayListRV);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApiActivity.this);

        rvApi.setLayoutManager(layoutManager);
        rvApi.setAdapter(postApiAdapter);

//        Toast.makeText(this, "Enterd", Toast.LENGTH_SHORT).show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/posts", new Response.Listener<String>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(String response) {

//                Toast.makeText(ApiActivity.this, "Volly", Toast.LENGTH_SHORT).show();
                Type type = new TypeToken<ArrayList<PostApi>>(){}.getType();

                ArrayList<PostApi> postApiArrayList = new Gson().fromJson(response, type);

                for (PostApi postApi : postApiArrayList) {
                    Log.d(TAG, "onResponse: ////"+postApi.id);
                }

                postApiArrayListRV.addAll(postApiArrayList);
                postApiAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: ///" + error.getMessage());
                Toast.makeText(ApiActivity.this, "Fialed", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(ApiActivity.this);
        requestQueue.add(stringRequest);

    }
}