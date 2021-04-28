package com.example.w11_28452;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postViewHolder> {

    //connecting the data model (arrayList)
    ArrayList<PostModel> post ;

    //constructor
    PostAdapter(ArrayList<PostModel> posts){
        this.post = posts;
    }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        holder.tvTitle.setText(post.get(position).getTitle());
        holder.tvBody.setText(post.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public class postViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvBody;

        public postViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);

        }
    }
}
