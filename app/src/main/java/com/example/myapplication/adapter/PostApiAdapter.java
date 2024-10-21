package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.PostApi;

import java.util.ArrayList;

public class PostApiAdapter extends RecyclerView.Adapter<PostApiAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<PostApi> postApiArrayList = new ArrayList<>();

    public PostApiAdapter(Context context, ArrayList<PostApi> postApiArrayList) {
        this.context = context;
        this.postApiArrayList = postApiArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_postapi, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PostApi postApi = postApiArrayList.get(position);

        holder.txtUserId.setText(String.valueOf(postApi.userId));
        holder.txtId.setText(String.valueOf(postApi.id));
        holder.txtTitle.setText(postApi.title);
        holder.txtBody.setText(postApi.body);

    }

    @Override
    public int getItemCount() {
        return postApiArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId, txtUserId, txtBody, txtTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txt_id);
            txtUserId = itemView.findViewById(R.id.txt_userId);
            txtBody = itemView.findViewById(R.id.txt_body);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }


}
