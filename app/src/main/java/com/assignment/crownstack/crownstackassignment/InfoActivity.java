package com.assignment.crownstack.crownstackassignment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    int position =0;
    ImageView play;
    Model model;
    int tap=0;
 MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        position=getIntent().getIntExtra("Position",0);
         model=MainActivity.dataList.get(position);
        TextView trackName=(TextView)findViewById(R.id.title_track);
        TextView rl_date=(TextView)findViewById(R.id.rl_date);
        TextView genric=(TextView)findViewById(R.id.genric);
        TextView price=(TextView)findViewById(R.id.price);
        TextView collection_name=(TextView)findViewById(R.id.collection_name);
        TextView artistName=(TextView)findViewById(R.id.artistName);
        TextView isStreamable=(TextView)findViewById(R.id.isStreamable);
        TextView country=(TextView)findViewById(R.id.country);
        TextView discNumber=(TextView)findViewById(R.id.discNumber);
        TextView trackCount=(TextView)findViewById(R.id.trackCount);
        TextView artistId=(TextView)findViewById(R.id.artistId);
        TextView collectionId=(TextView)findViewById(R.id.collectionId);
        TextView trackId=(TextView)findViewById(R.id.trackId);
        ImageView im=(ImageView)findViewById(R.id.profile_image);
       play=(ImageView)findViewById(R.id.play_btn);
        Button collectionView=(Button) findViewById(R.id.v_collection);
        Button trackView=(Button) findViewById(R.id.v_track);
        Button ArtistView=(Button) findViewById(R.id.v_artist);
        collectionView.setOnClickListener(this);
        trackView.setOnClickListener(this);
        ArtistView.setOnClickListener(this);
        play.setOnClickListener(this);


        Picasso.get().
                load(model.getArtworkUrl100())
                .placeholder(R.drawable.index).centerCrop()
                .fit()
                .into(im);
        trackName.setText(model.getTrackName());
        rl_date.setText("Relase Date : "+ model.getReleaseDate());
        genric.setText(model.getPrimaryGenreName());
        price.setText("Collection Price : "+model.getCollectionPrice());
        collection_name.setText(model.getCollectionName());
        artistName.setText("Artist Name : "+model.getArtistName());
        isStreamable.setText("Streamable : "+model.getIsStreamable());
        country.setText("Country : "+model.getCountry());
        discNumber.setText("DiscNumber : "+model.getDiscNumber());
        trackCount.setText("Track Number : "+model.getTrackCount());
        artistId.setText("Artist Id : "+model.getArtistId());
        collectionId.setText("Collection Id : "+model.getCollectionId());
        trackId.setText("Currency : "+model.getCurrency());






    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play_btn){
            if(tap%2==0) {
                Toast.makeText(this, "Please wait....", Toast.LENGTH_LONG).show();
                play.setImageResource(R.drawable.bpause);
                killMediaPlayer();
                try {
                    playLocalAudio(model.getPreviewUrl());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                play.setImageResource(R.drawable.bplay);
                mediaPlayer.pause();
            }

        }
        if(view.getId()==R.id.v_collection){
            Intent i=new Intent(this,WebViewActivity.class);
            i.putExtra("url",model.getCollectionViewUrl());
            startActivity(i);

        }
        if(view.getId()==R.id.v_artist){
            Intent i=new Intent(this,WebViewActivity.class);
            i.putExtra("url",model.getArtistViewUrl());
            startActivity(i);

        }
        if(view.getId()==R.id.v_track){
            Intent i=new Intent(this,WebViewActivity.class);
            i.putExtra("url",model.getTrackViewUrl());
            startActivity(i);

        }
    }
  void playLocalAudio(String url) throws IOException {
        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

  void killMediaPlayer() {
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
    protected void onPause() {
        super.onPause();
        if(mediaPlayer!=null && mediaPlayer.isPlaying())
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
