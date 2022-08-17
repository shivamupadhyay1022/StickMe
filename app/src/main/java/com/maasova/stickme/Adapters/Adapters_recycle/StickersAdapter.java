package com.maasova.stickme.Adapters.Adapters_recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.maasova.stickme.R;

import java.util.ArrayList;

public class StickersAdapter extends RecyclerView.Adapter<StickersAdapter.viewholder>{

    private ArrayList<String> imagelist;

    public StickersAdapter(ArrayList<String> imagelist, Context context) {
        this.imagelist = imagelist;
        this.context = context;
    }
    private Context context;
    @NonNull
    @Override

    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stickers_recycle,parent,false);
        return new viewholder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(imagelist.get(position)).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).placeholder(R.drawable.mainlogo).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder
    {   ImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.stickers_layout_recycle);
        }
    }
}
