package com.it1k10.thegioitruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ManThongTin extends AppCompatActivity {

    TextView txtThongtinapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_tin);

        txtThongtinapp = findViewById(R.id.textViewthongtin);
        String thongtin = "Ứng dụng được phát triển nhằm mục đích giải trí !";
        txtThongtinapp.setText(thongtin);
    }
}