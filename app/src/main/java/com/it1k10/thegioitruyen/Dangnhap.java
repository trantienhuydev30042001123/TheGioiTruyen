package com.it1k10.thegioitruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.it1k10.thegioitruyen.database.databasedoctruyen;

public class Dangnhap extends AppCompatActivity {

    // tạo biến cho đăng nhập
    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap, btnDangKy;

    // tạo đối tượng cho databasedoctruyen
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        AnhXa();
        // đối tượng databasedoctruyen
        databasedoctruyen = new databasedoctruyen(this);

        //tạo sự kiện click button chuyển sang màn hinhd đăng ký với intend
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dangnhap.this,DangKy.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gán cho các biến giá trị nhập vào từ editText
                String tentaikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();

                //Sử dụng con trỏ để lấy dữ liệu
                Cursor cursor = databasedoctruyen.getData();

                // thực hiện vòng lặp để lấy dữ liệu từ cursor với
                while (cursor.moveToNext()){

                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);

                    if (datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                        int phanquyen =cursor.getInt(4);
                        int idd =cursor.getInt(0);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        Intent intent = new Intent(Dangnhap.this,MainActivity.class);

                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("email",email);
                        intent.putExtra("tentaikhoan",tentk);

                        startActivity(intent);
                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }

    private void AnhXa() {
        edtMatKhau = findViewById(R.id.matkhau);
        edtTaiKhoan = findViewById(R.id.taikhoan);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);
    }
}