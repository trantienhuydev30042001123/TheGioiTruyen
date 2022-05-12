package com.it1k10.thegioitruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.it1k10.thegioitruyen.R;
import com.it1k10.thegioitruyen.model.Truyen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterTruyen extends BaseAdapter {

    private Context context;
    private ArrayList<Truyen> listTruyen;

    public adapterTruyen(Context context, ArrayList<Truyen> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //filter
    public void filterList(ArrayList<Truyen> filteredList) {
        listTruyen = filteredList;
        notifyDataSetChanged();
    }

    public  class ViewHolder{
        TextView txtTexTruyen;
        ImageView imgtruyen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder();

        LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.newtruyen,null);

        viewHolder.txtTexTruyen = convertView.findViewById(R.id.textviewTentruyenNew);
        viewHolder.imgtruyen = convertView.findViewById(R.id.imgNewTruyen);
        convertView.setTag(viewHolder);

        Truyen truyen = (Truyen) getItem(position);
        viewHolder.txtTexTruyen.setText(truyen.getTenTruyen());

        Picasso.get().load(truyen.getAnh()).placeholder(R.drawable.ic_load).error(R.drawable.ic_image).into(viewHolder.imgtruyen);


        return convertView;
    }

}
