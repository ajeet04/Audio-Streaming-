package com.assignment.crownstack.crownstackassignment;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsynTasks extends AsyncTask<String,String,String> {


    private static final String TAG = "TASKKKK";
    private Context context;
    private RecyclerView mListView;
    public AsynTasks(Context context,RecyclerView mListView){
        this.context=context;
        this.mListView=mListView;
    }
    public AsynTasks(){}


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivity.mProgress.show();
        MainActivity.dataList.clear();
    }

    @Override
    protected String doInBackground(String... strings) {


        try {
            URL myUrl=new URL(strings[0]);
            HttpURLConnection connection=(HttpURLConnection) myUrl.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            Log.d("ajeet", buffer.toString());
            String json=buffer.toString();
            JSONObject jObject=null;
            JSONObject jObj= new JSONObject(json);
            JSONArray array = jObj.getJSONArray("results");
            for(int i=0;i<array.length();i++){
                JSONObject o= array.getJSONObject(i);

                String wrapperType=o.getString("wrapperType");
                String artistId=o.getString("artistId");
                String collectionId=o.getString("collectionId");
                String artistName=o.getString("artistName");
                String collectionName=o.getString("collectionName");

                String trackName=o.getString("trackName");
                String collectionCensoredName=o.getString("collectionCensoredName");
                String trackCensoredName=o.getString("trackCensoredName");
                String artistViewUrl=o.getString("artistViewUrl");
                String collectionViewUrl=o.getString("collectionViewUrl");

                String trackViewUrl=o.getString("trackViewUrl");
                String previewUrl=o.getString("previewUrl");
                String artworkUrl30=o.getString("artworkUrl30");
                String artworkUrl60=o.getString("artworkUrl60");
                String artworkUrl100=o.getString("artworkUrl100");

                String collectionPrice=o.getString("collectionPrice");
                String collectionExplicitness=o.getString("collectionExplicitness");
                String releaseDate=o.getString("releaseDate");
                String trackExplicitness=o.getString("trackExplicitness");
                String discCount=o.getString("discCount");

                String discNumber=o.getString("discNumber");
                String trackCount=o.getString("trackCount");
                String trackTimeMillis=o.getString("trackTimeMillis");
                String country=o.getString("country");
                String currency=o.getString("currency");

                String primaryGenreName=o.getString("primaryGenreName");
                String isStreamable=o.getString("isStreamable");

                Model model =new Model(wrapperType, artistId , collectionId,  artistName,  collectionName , trackName,
                         collectionCensoredName , trackCensoredName,  artistViewUrl,  collectionViewUrl , trackViewUrl,
                         previewUrl,  artworkUrl30,  artworkUrl60 , artworkUrl100,  collectionPrice,
                         collectionExplicitness,  releaseDate,  trackExplicitness,  discCount,  discNumber,   trackCount,
                         trackTimeMillis,  country , currency,  primaryGenreName , isStreamable);
                MainActivity.dataList.add(model);



//


            }



        } catch (MalformedURLException e) {
          //  MainActivity.mProgress.hide();

        } catch (IOException e) {
          //  MainActivity.mProgress.hide();

        } catch (JSONException e) {
          //  MainActivity.mProgress.hide();

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        MainActivity.mProgress.hide();
        ListAdapter mAdatper=new ListAdapter(MainActivity.dataList,context);
        mListView.setAdapter(mAdatper);

        Log.d("List SIZE************",MainActivity.dataList.size()+"");
       // Toast.makeText(context,MainActivity.dataList.size()+""+ MainActivity.dataList.get(1).getArtworkUrl60(), Toast.LENGTH_SHORT).show();
    }
}
