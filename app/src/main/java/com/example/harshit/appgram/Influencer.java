
package com.example.harshit.appgram;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Influencer extends RecyclerView.Adapter<Influencer.ViewHolder> {


    private Context context;
    private ArrayList<UserTable> userTables;
    public Influencer(Context context, ArrayList<UserTable> userTables)
    {
        this.context=context;
        this.userTables=userTables;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layInFlt = LayoutInflater.from(viewGroup.getContext());
        View listitem = layInFlt.inflate(R.layout.activity_influencer, viewGroup, false);
        Influencer.ViewHolder v = new Influencer.ViewHolder(listitem);
        return v;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.name.setText(userTables.get(i).name);
        viewHolder.email.setText(userTables.get(i).email);
        viewHolder.username.setText(userTables.get(i).username);
        viewHolder.follower.setText(userTables.get(i).followers);
        viewHolder.likes.setText(userTables.get(i).likes);
        viewHolder.post.setText(userTables.get(i).post);




        viewHolder.useView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,userTables.get(i).table_name,Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return userTables.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,username,follower,likes,post;
        LinearLayout useView;
        ImageView image;
        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            image=itemview.findViewById(R.id.image);
            useView=itemView.findViewById(R.id.useView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            username=itemView.findViewById(R.id.username);
            follower=itemView.findViewById(R.id.follower);
            likes=itemView.findViewById(R.id.likes);
            post=itemView.findViewById(R.id.post);

        }

    }


}
