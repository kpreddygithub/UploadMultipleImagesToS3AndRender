package com.reputation.reputationapplication;

/**
 * Created by MyDukan_SHIVAYOGI on 08-02-2018.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter extends BaseAdapter {
    private String S3_URL = "https://s3.us-east-2.amazonaws.com/reputation-interview/";
    private final ArrayList<HashMap<String, Object>> transferRecordMaps;
    // Declare Variables
    Context context;

    LayoutInflater inflater;

    public ListViewAdapter(Context context, ArrayList<HashMap<String, Object>> transferRecordMaps) {
        this.context = context;
        this.transferRecordMaps = transferRecordMaps;
    }

    @Override
    public int getCount() {
        return transferRecordMaps.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.bucket_item, parent, false);
        ImageView imageView = itemView.findViewById(R.id.image_view);
        TextView keyTextView = itemView.findViewById(R.id.key);
        HashMap<String, Object> objectHashMap = transferRecordMaps.get(position);
        Object key = objectHashMap.get("key");
        keyTextView.setText((String) key);
        Glide.with(context)
                .load(S3_URL + (String) key)
                .centerCrop()
                .placeholder(R.drawable.image_loader)
                .into(imageView);
        return itemView;
    }
}