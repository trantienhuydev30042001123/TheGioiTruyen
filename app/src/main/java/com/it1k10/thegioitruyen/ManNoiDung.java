package com.it1k10.thegioitruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ManNoiDung extends AppCompatActivity {

    TextView txtTenTruyen,txtNoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_noi_dung);

        txtNoiDung = findViewById(R.id.noidung);
        txtTenTruyen = findViewById(R.id.TenTruyen);

        // lấy dữ liệu
        Intent intent = getIntent();
        String tentruyen = intent.getStringExtra("tentruyen");
        String noidung = intent.getStringExtra("noidung");

        txtTenTruyen.setText(tentruyen);
        txtNoiDung.setText(noidung);

        // cho phép cuộn nội dung truyện
        txtNoiDung.setMovementMethod(new ScrollingMovementMethod());
    }
}