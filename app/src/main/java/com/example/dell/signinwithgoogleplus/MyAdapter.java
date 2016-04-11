package com.example.dell.signinwithgoogleplus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by dell on 11/04/2016.
 */
public class MyAdapter extends BaseAdapter {

   LayoutInflater my_inflate;
    ArrayList<String> my_array;
    public MyAdapter( Activity activity,ArrayList x){
        my_inflate=activity.getLayoutInflater();
        my_array=x;
    }


    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public int getCount() {
        return my_array.size();
    }

    @Override
    public Object getItem(int position) {
        return my_array.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = my_inflate.inflate(R.layout.item, null);
        }
        TextView cc=(TextView)convertView.findViewById(R.id.soha);
        cc.setText(my_array.get(position));

        return convertView;
    }
}
