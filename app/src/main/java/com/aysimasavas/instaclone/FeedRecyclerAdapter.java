package com.aysimasavas.instaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {


    ArrayList<String> userEmailList;
    ArrayList<String> userCommentList;
    ArrayList<String> userImageList;

    public FeedRecyclerAdapter(ArrayList<String> userEmailList, ArrayList<String> userCommentList, ArrayList<String> userImageList) {
        this.userEmailList = userEmailList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.userEmailText.setText(userEmailList.get(position));
        holder.commentText.setText(userCommentList.get(position));

        Picasso.get().load(userImageList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {


        return userEmailList.size();
    }

    class PostHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView userEmailText,commentText;
        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.recycler_imageView);
            userEmailText=itemView.findViewById(R.id.recyler_useremailText);
            commentText=itemView.findViewById(R.id.recyler_commentText);

        }
    }
}
