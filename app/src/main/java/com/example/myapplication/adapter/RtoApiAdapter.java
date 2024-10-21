package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.RtoModel.Rto;

import java.util.ArrayList;

public class RtoApiAdapter extends RecyclerView.Adapter<RtoApiAdapter.MyViewHolder> {

    private Context context;
    private static final String TAG = "RtoApiAdapter";
    private ArrayList<Rto> tagRtoInfoArrayList = new ArrayList<>();

    public RtoApiAdapter(Context context, ArrayList<Rto> tagRtoInfoArrayList) {
        this.context = context;
        this.tagRtoInfoArrayList = tagRtoInfoArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rtoapi, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Rto tagRtoInfo = tagRtoInfoArrayList.get(position);
        holder.txtContryName.setText(tagRtoInfo.getId());

        Log.d(TAG, "onBindViewHolder: +-+-"+tagRtoInfo.getId());
    }

    @Override
    public int getItemCount() {
        return tagRtoInfoArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtContryName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtContryName = itemView.findViewById(R.id.txt_contryName);
        }
    }

}
