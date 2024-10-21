package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.RtoApiAdapter;
import com.example.myapplication.models.RtoModel.Rto;

import java.util.ArrayList;

public class RtoApiActivity extends AppCompatActivity {

    private static final String TAG = "RtoApiActivity";
    private RecyclerView rvRtoApi;
    private RtoApiAdapter rtoApiAdapter;
    private ArrayList<Rto> RtoListRV = new ArrayList<>();
    private String url = "https://rbrgloblesolution.in/RTOInformation/rtoinformation.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rto_api);
        initViews();
    }

    private void initViews() {
        rvRtoApi = findViewById(R.id.rv_rtoApi);

        // Create layout manager and adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvRtoApi.setLayoutManager(layoutManager);
        rtoApiAdapter = new RtoApiAdapter(this, RtoListRV);
        rvRtoApi.setAdapter(rtoApiAdapter);

        // Initialize Volley request
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onResponse(String response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: Volley error" + error.getMessage());
                    }
                });

        // Add request to the queue
        requestQueue.add(stringRequest);
    }
}