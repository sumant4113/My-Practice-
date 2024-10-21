package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.models.Photo;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Photo> arrayList = new ArrayList<>();

    public PhotoAdapter(Context context, ArrayList<Photo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Photo photo = arrayList.get(position);

        Glide.with(context).load(photo.url).into(holder.imgUrl);
        Glide.with(context).load(photo.thumbnailUrl).into(holder.imgThumbnailUrl);

        holder.txtAlbumId.setText(String.valueOf(photo.albumId));
        holder.txtId.setText(String.valueOf(photo.id));
        holder.txtTitle.setText(photo.title);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgThumbnailUrl, imgUrl;
        private TextView txtTitle, txtId, txtAlbumId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
            txtAlbumId = itemView.findViewById(R.id.txt_albumId);
            txtTitle = itemView.findViewById(R.id.txt_title);

            imgThumbnailUrl = itemView.findViewById(R.id.img_thumbnailUrl);
            imgUrl = itemView.findViewById(R.id.img_url);
        }
    }

}
