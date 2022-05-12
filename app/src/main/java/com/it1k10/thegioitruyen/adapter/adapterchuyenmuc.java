package com.it1k10.thegioitruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.it1k10.thegioitruyen.R;
import com.it1k10.thegioitruyen.model.chuyenmuc;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterchuyenmuc extends BaseAdapter {

    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmucList;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmucList = chuyenmucList;
    }

    @Override
    public int getCount() {
        return chuyenmucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout,null);

        ImageView img = (ImageView) convertView.findViewById(R.id.imgchuyenmuc);

        TextView txt = (TextView) convertView.findViewById(R.id.textviewTenchuyenmuc);

        chuyenmuc cm = chuyenmucList.get(position);

        txt.setText(cm.getTenchuyenmuc());

        img.setImageResource(cm.getHinhanhchuyenmuc());


        return convertView;
    }
}
