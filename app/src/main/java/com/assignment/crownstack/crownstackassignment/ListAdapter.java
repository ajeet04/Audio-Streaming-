package com.assignment.crownstack.crownstackassignment;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<Model> myList=new ArrayList<>();
    static MediaPlayer mediaPlayer;
    static int i=0;
    private Context context;

    public ListAdapter(List<Model> myList,Context context){

        this.myList=myList;
        this.context=context;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.MyViewHolder myViewHolder, final int i) {
        final Model model=myList.get(i);
        myViewHolder.titleTrack.setText(model.getTrackName());
        myViewHolder.collectionName.setText(model.collectionName);
        long millis = Long.parseLong(model.getTrackTimeMillis());  // obtained from StopWatch
        long minutes = (millis / 1000)  / 60;
        int seconds = (int)((millis / 1000) % 60);
        myViewHolder.time.setText(minutes+" : "+seconds);
        //Log.d("Test",model.getArtworkUrl100());
        final ImageView im=myViewHolder.preview;
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                killMediaPlayer();
                Intent in=new Intent(context,InfoActivity.class);
                in.putExtra("Position",i);
                context.startActivity(in);

            }
        });
        Picasso.get().
                load(model.getArtworkUrl100())
                .placeholder(R.drawable.index).centerCrop()
                .fit()
                .into(im);

        myViewHolder.play.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {

                if (myViewHolder.play.isChecked()) {
                    try {
                        myViewHolder.play.setBackgroundResource(R.drawable.play);
                        Toast.makeText(context, "Please wait....", Toast.LENGTH_LONG).show();

                       playLocalAudio(model.getPreviewUrl());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{

                    myViewHolder.play.setBackgroundResource(R.drawable.pause);
                   mediaPlayer.pause();

                }
            }


        });


    }
    void playLocalAudio(String url) throws IOException {
        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    static void killMediaPlayer() {
        if(mediaPlayer!=null) {
            try {
                mediaPlayer.release();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public int getItemCount() {
        return myList.size();
    }

   protected static class MyViewHolder extends RecyclerView.ViewHolder {
      ImageView preview;
      ToggleButton play;
      TextView titleTrack,collectionName,time;
      int imm=0;
       public MyViewHolder(View view) {
           super(view);
           titleTrack = (TextView) view.findViewById(R.id.title_name);
           collectionName = (TextView) view.findViewById(R.id.coll_name);
           time = (TextView) view.findViewById(R.id.time);
           preview = (ImageView) view.findViewById(R.id.preview);
           play=(ToggleButton)view.findViewById(R.id.play);
       }
   }



}
