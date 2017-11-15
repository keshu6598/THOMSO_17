package com.project.nikhil.thomso17;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by nikhil on 6/10/17.
 */

public class adapter_team_list extends RecyclerView.Adapter<adapter_team_list.ViewHolder>{

    public ArrayList<team_member> mdatas;
    ViewGroup x;
    Context context;

    public adapter_team_list(ArrayList<team_member> myDataset) {
        mdatas = myDataset;
    }



    @Override
    public adapter_team_list.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        x=parent;
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_member,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final team_member o1=mdatas.get(position);
        holder.txt_name.setText(o1.getName());
        holder.txt_post.setText(o1.getPost());
        holder.mail.setText(o1.getEmail());
        holder.call.setText(o1.getPhone());

        Uri img=Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+"://com.project.nikhil.thomso17/drawable/"+o1.getImage().split("\\.")[0]);
        Typeface face1 = Typeface.createFromAsset(context.getAssets(),
                "fonts/gaurav.ttf");
        holder.txt_name.setTypeface(face1);
        holder.txt_post.setTypeface(face1);
        holder.mail.setTypeface(face1);
        holder.call.setTypeface(face1);


        holder.image.setImageURI(img);
        //holder.image.setImageResource(R.drawable.);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:"+o1.getPhone();
                i.setData(Uri.parse(p));
                context.startActivity(i);

            }
        });

        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name,txt_post,mail,call;
        public CircleImageView image;

        public ViewHolder(View itemView) {

            super(itemView);

            txt_name=(TextView)itemView.findViewById(R.id.team_name);
            txt_post=(TextView)itemView.findViewById(R.id.team_post);
            image=(CircleImageView) itemView.findViewById(R.id.team_image);
            mail=(TextView)itemView.findViewById(R.id.team_mail);
            call=(TextView)itemView.findViewById(R.id.team_call);
            context=itemView.getContext();


        }
    }
}
