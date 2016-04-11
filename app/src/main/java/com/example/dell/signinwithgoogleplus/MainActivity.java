package com.example.dell.signinwithgoogleplus;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map config = new HashMap();
        config.put("cloud_name", "dikedyr6k");
        config.put("api_key", "739549973538329");
        config.put("api_secret", "-ubdv86l0YtSg59af38aLj-9Bbk");
        final Cloudinary cloudinary = new Cloudinary(config);
        ImageView imageView1=(ImageView)findViewById(R.id.imageView);
        Picasso.with(this).load("http://res.cloudinary.com/dikedyr6k/image/upload/v1459760977/sample.jpg").into(imageView1);
        AsyncTask<Void, Void, String> task=new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                Log.i("image ","do in back ground ");

                try {
                    Uri path = Uri.parse("android.resource://com.example.dell.signinwithgoogleplus/drawable/add");
                    Log.i("image",path.toString()+"");

                    cloudinary.uploader().upload(path.toString(),
                            ObjectUtils.asMap("api_key", "739549973538329","resource_type", "image"));
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("image", e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                Log.i("image ","done");
            }
        };
        task.execute();

    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
