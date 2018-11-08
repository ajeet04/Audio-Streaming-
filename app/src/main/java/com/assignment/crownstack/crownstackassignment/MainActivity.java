package com.assignment.crownstack.crownstackassignment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static ProgressDialog mProgress;
    private RecyclerView mListView;
    LinearLayoutManager mLayoutManager;
    int grid=2;
    private static String Url="https://itunes.apple.com/search?term=Michael+jackson";
    public Context context=MainActivity.this;
    public static List<Model> dataList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress=new ProgressDialog(this);
        mProgress.setMessage("Fetching data...");

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            grid=3;
        }
        else{
            grid=2;
        }
        mListView=(RecyclerView)findViewById(R.id.list);
        mLayoutManager=new GridLayoutManager(this,grid);
        mListView.setLayoutManager(mLayoutManager);
        mProgress.setCanceledOnTouchOutside(false);
        AsynTasks myAsynTask=new AsynTasks(this,mListView);
        myAsynTask.execute(Url);




    }

    @Override
    protected void onPause() {
        super.onPause();
        if( ListAdapter.mediaPlayer!=null &&  ListAdapter.mediaPlayer.isPlaying())
        ListAdapter.mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ListAdapter.mediaPlayer!=null) {
            try {
                ListAdapter.mediaPlayer.release();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
}

