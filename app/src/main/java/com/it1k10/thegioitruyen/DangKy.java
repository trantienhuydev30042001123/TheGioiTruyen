package com.it1k10.thegioitruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.it1k10.thegioitruyen.database.databasedoctruyen;
import com.it1k10.thegioitruyen.model.Taikhoan;

public class DangKy extends AppCompatActivity {

    EditText edtDKTaiKhoan,edtDKMatKhau,edtDKEmail;
    Button btnDKDangKy,btnDKDangNhap;

    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        databasedoctruyen = new databasedoctruyen(this);

        AnhXa();
        // click cho button đăng ký
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtDKTaiKhoan.getText().toString();
                String matkhau = edtDKMatKhau.getText().toString();
                String email = edtDKEmail.getText().toString();

                Taikhoan taikhoan1 = CreateTaiKhoan();
                if (taikhoan.equals("") || email.equals("")){
                    Log.e("Thông báo : ", "Chưa nhập đầy đủ thông tin");
                }
                // nếu đầy đủ thông tin nhập vào thì add tài khoản vào database
                else{
                    databasedoctruyen.AddTaikhoan(taikhoan1);
                    Toast.makeText(DangKy.this,"Đăng Ký thành công",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
// trở về đăng nhập
        btnDKDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //Phương thức tạo tài khoản
    private Taikhoan CreateTaiKhoan(){
        String taikhoan = edtDKTaiKhoan.getText().toString();
        String matkhau = edtDKMatKhau.getText().toString();
        String email = edtDKEmail.getText().toString();
        int phanquyen = 2;

        Taikhoan tk = new Taikhoan(taikhoan,matkhau,email,phanquyen);

        return tk;
    }

    private void AnhXa(){
        edtDKEmail = findViewById(R.id.dkemail);
        edtDKMatKhau = findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan = findViewById(R.id.dktaikhoan);
        btnDKDangKy = findViewById(R.id.dkdangky);
        btnDKDangNhap = findViewById(R.id.dkdangnhap);
    }
}