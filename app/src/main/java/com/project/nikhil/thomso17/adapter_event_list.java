package com.project.nikhil.thomso17;

import android.content.ContentResolver;
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

import java.util.ArrayList;

/**
 * Created by nikhil on 8/10/17.
 */

public class adapter_event_list extends RecyclerView.Adapter<adapter_event_list.ViewHolder>{

public ArrayList<event_object> mdatas;
        ViewGroup x;
        Context context;

public adapter_event_list(ArrayList<event_object> myDataset) {
        mdatas = myDataset;
        }



@Override
public adapter_event_list.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        x=parent;
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_object,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
        }




@Override
public void onBindViewHolder(ViewHolder holder, int position) {
  final event_object o1=mdatas.get(position);
        holder.txt_name.setText(o1.getName());
        holder.txt_location.setText(o1.getVenue());
        holder.time.setText(o1.getStart_time()+"-"+o1.getEnd_time());

        holder.txt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+o1.getLat().toString()+","+o1.getLng().toString()+"&mode=w" );
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                }

            }
        });
    Typeface face1 = Typeface.createFromAsset(context.getAssets(),
            "fonts/gaurav.ttf");
    holder.txt_name.setTypeface(face1);
    holder.txt_location.setTypeface(face1);
    holder.time.setTypeface(face1);


    holder.setOnItemClickListener(new MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent=new Intent(context,event_overview.class);
                intent.putExtra("describe",o1);
                context.startActivity(intent);

            }
        });

           }

@Override
public int getItemCount() {
        return mdatas.size();
        }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txt_name,txt_location,time;
    private MyClickListener myClickListener;

    public ViewHolder(View itemView) {

        super(itemView);

        txt_name=(TextView)itemView.findViewById(R.id.event_object_name);
        txt_location=(TextView)itemView.findViewById(R.id.event_object_loc);
        time=(TextView)itemView.findViewById(R.id.event_object_time);

        itemView.setOnClickListener(this);
        context=itemView.getContext();

    }

    @Override
    public void onClick(View v) {
        myClickListener.onItemClick(getLayoutPosition(), v);

    }
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;

    }
}
}

