package com.it1k10.thegioitruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.it1k10.thegioitruyen.database.databasedoctruyen;
import com.it1k10.thegioitruyen.model.Truyen;

public class ManDangBai extends AppCompatActivity {

    EditText edtTenTruyen,edtNoiDung,edtAnh;
    Button btlDangBai;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh = findViewById(R.id.dbimg);
        edtTenTruyen = findViewById(R.id.dbTentruyen);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btlDangBai = findViewById(R.id.dbdangbai);

        databasedoctruyen = new databasedoctruyen(this);
        // button đăng bài
        btlDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tentruyen = edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();

                Truyen truyen = CreatTruyen();

                if (tentruyen.equals("")|| img.equals("")){
                    Toast.makeText(ManDangBai.this,"Yêu cầu nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                    Log.e("ERR : ", "Nhập đầy đủ thông tin");

                }
                // nếu nhập đầy đủ thông tin thì thực hiện thêm dữ liệu
                else{
                    databasedoctruyen.AddTruyen(truyen);

                    // chuyển qua màn hình Admin và cập nhật dữ liệu
                    Intent intent = new Intent(ManDangBai.this,ManAdmin.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }
    private Truyen CreatTruyen(){
        String tentruyen = edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();

        Intent intent = getIntent();
        int id = intent.getIntExtra("Id",0);

        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return truyen;
    }
}