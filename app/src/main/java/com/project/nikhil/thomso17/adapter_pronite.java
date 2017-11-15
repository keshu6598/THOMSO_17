package com.project.nikhil.thomso17;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nikhil on 14/10/17.
 */

public class adapter_pronite extends RecyclerView.Adapter<adapter_pronite.ViewHolder> {

    public ArrayList<pronite> mdatas;
    ViewGroup x;
    Context context;

    public adapter_pronite(ArrayList<pronite> myDataset) {
        mdatas = myDataset;
    }



    @Override
    public adapter_pronite.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        x=parent;
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.pronite_cell,parent,false);
        adapter_pronite.ViewHolder vh=new adapter_pronite.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final pronite o1=mdatas.get(position);

        holder.txt_name.setText(o1.getVenue());
        holder.txt_artist.setText(o1.getArtist());
        holder.txt_day.setText(o1.getDay()+"("+o1.getName()+")");
       // holder.txt_venue.setText(o1.getVenue());

        Typeface face1 = Typeface.createFromAsset(context.getAssets(),
                "fonts/gaurav.ttf");

        holder.txt_name.setTypeface(face1);
        holder.txt_day.setTypeface(face1);
        holder.txt_artist.setTypeface(face1);
       // holder.txt_venue.setTypeface(face1);

        Toast.makeText(context,o1.getDay().toString(),Toast.LENGTH_SHORT);
        Picasso.with(context).load(o1.getImage()).error(R.drawable.error_image).into(holder.imageView);


    }



    @Override
    public int getItemCount() {
        return mdatas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txt_name, txt_artist, txt_day,txt_venue;
        public ImageView imageView;

        public ViewHolder(View itemView) {

            super(itemView);

            txt_name = (TextView) itemView.findViewById(R.id.pronite_name);
            txt_artist = (TextView) itemView.findViewById(R.id.pronite_artist);
            txt_day = (TextView) itemView.findViewById(R.id.pronite_day);
           // txt_venue=(TextView)itemView.findViewById(R.id.pronite_location);

            imageView = (ImageView) itemView.findViewById(R.id.pronite_image);

            context = itemView.getContext();

        }

    }
}
