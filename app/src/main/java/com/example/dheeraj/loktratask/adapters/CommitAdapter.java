package com.example.dheeraj.loktratask.adapters;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dheeraj.loktratask.R;
import com.example.dheeraj.loktratask.models.CommitData;
import com.squareup.picasso.Picasso;

import java.security.spec.RSAPrivateKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by dheeraj on 15/6/18.
 */

public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.CommitViewHolder>{
    public Context ctx;
    public CommitData[] data;
    SimpleDateFormat sdf1,sdf2;

    public CommitAdapter(Context ctx, CommitData[] data) {
        this.ctx = ctx;
        this.data = data;
        sdf1=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        sdf2=new SimpleDateFormat("dd-MMM-yyyy");
    }

    @Override
    public CommitAdapter.CommitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.commitlayout,parent,false);
        return new CommitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommitAdapter.CommitViewHolder holder, int position) {
        holder.tvname.setText(data[position].commit.author.getName());
        try {
            holder.tvdate.setText("Dated:"+sdf2.format(sdf1.parse(data[position].commit.author.date)).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.tvmessage.setText("Commit Message:"+data[position].commit.message);
        Picasso.with(ctx).load(data[position].author.avatar_url).into(holder.ivprofile);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CommitViewHolder extends RecyclerView.ViewHolder{

        ImageView ivprofile;
        TextView tvname,tvdate,tvmessage;

        public CommitViewHolder(View itemView) {
            super(itemView);
            ivprofile=(ImageView) itemView.findViewById(R.id.profilepic);
            tvname=(TextView) itemView.findViewById(R.id.tvname);
            tvdate=(TextView) itemView.findViewById(R.id.tvdate);
            tvmessage=(TextView) itemView.findViewById(R.id.tvmessage);
        }
    }
}
