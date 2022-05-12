package com.it1k10.thegioitruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.it1k10.thegioitruyen.R;
import com.it1k10.thegioitruyen.model.Taikhoan;

import org.w3c.dom.Text;

import java.util.List;

public class adapterthongtin extends BaseAdapter {

    private Context context;
    private int layout;

    private List<Taikhoan> taikhoanList;

    public adapterthongtin(Context context, int layout, List<Taikhoan> taikhoanList) {
        this.context = context;
        this.layout = layout;
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int getCount() {
        return taikhoanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtTenTaiKhoan = (TextView) convertView.findViewById(R.id.TEXT_NAME);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.TEXT_Gmail);

        Taikhoan taiKhoan = taikhoanList.get(position);

        txtTenTaiKhoan.setText(taiKhoan.getmTenTaikhoan());
        txtEmail.setText(taiKhoan.getmEmail());

        return convertView;
    }
}
