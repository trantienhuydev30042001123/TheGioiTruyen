package com.it1k10.thegioitruyen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.it1k10.thegioitruyen.adapter.adapterTruyen;
import com.it1k10.thegioitruyen.adapter.adapterchuyenmuc;
import com.it1k10.thegioitruyen.adapter.adapterthongtin;
import com.it1k10.thegioitruyen.database.databasedoctruyen;
import com.it1k10.thegioitruyen.model.Taikhoan;
import com.it1k10.thegioitruyen.model.Truyen;
import com.it1k10.thegioitruyen.model.chuyenmuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView,listViewNew,listViewThongTin;
    DrawerLayout drawerLayout;

    String email;
    String tentaikhoan;

    ArrayList<Truyen> TruyenArraylist;

    adapterTruyen adapterTruyen;

    ArrayList<chuyenmuc> chuyenmucArrayList;

    ArrayList<Taikhoan> taikhoanArrayList;

    databasedoctruyen databasedoctruyen;

    adapterchuyenmuc adapterchuyenmuc;

    adapterthongtin adapterthongtin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasedoctruyen = new databasedoctruyen(this);

        // Nh???n d??? li???u ??? m??n ????ng nh???p g???i
        Intent intenpq = getIntent();
        int i = intenpq.getIntExtra("phanq",0);
        int idd = intenpq.getIntExtra("idd",0);
        email = intenpq.getStringExtra("email");
        tentaikhoan = intenpq.getStringExtra("tentaikhoan");

        AnhXa();
        ActionBar();
        ActionViewFlipper();

        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this,ManNoiDung.class);

            String tent = TruyenArraylist.get(position).getTenTruyen();
            String noidungt = TruyenArraylist.get(position).getNoiDung();
            intent.putExtra("tentruyen",tent);
            intent.putExtra("noidung",noidungt);
            startActivity(intent);
            }
        });
        // ???n click item cho listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ????ng b??i
                if (position==0){
                    if (i==1){
                    Intent intent = new Intent(MainActivity.this,ManAdmin.class);
                    // g???i id t??i kho???n qua m??n admin
                    intent.putExtra("Id",idd);
                    startActivity(intent);
                    }else if(i==2){
                        Toast.makeText(MainActivity.this,"B???n kh??ng c?? quy???n ????ng b??i ", Toast.LENGTH_SHORT).show();
                        Log.e("????ng b??i : ","B???n kh??ng c?? quy???n ");
                    }
                }
                // n???u v??? tr?? ???n v??o l?? th??ng tin th?? s??? chuy???n qua m??n h??nh th??ng tin app
                else if(position == 1){
                    Intent intent = new Intent(MainActivity.this,ManThongTin.class);
                    startActivity(intent);
                }
                // ????ng xu???t
                else if (position == 2){
                    finish();
                }
            }
        });

    }

    // thanh Actionbar v???i toolbar
    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    // T???o icon cho toolbar
    toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
    //B???t s??? ki???n click
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    });

    }
    //Phuwogn th???c cho ch???y qu???ng c??o v???i viewFilipper
    private void ActionViewFlipper() {
        //m???ng ch???a t???m ???nh cho qu???ng c??o
        ArrayList<String> mangquangcao = new ArrayList<>();
        // Add ???nh v??o m???ng. th??m 4 ???nh qu???ng c??o
        mangquangcao.add("https://gamek.mediacdn.vn/133514250583805952/2022/4/15/photo-1-16500183002801275175046.jpeg");
        mangquangcao.add("https://s.meta.com.vn/img/thumb.ashx/Data/image/2021/11/01/lich-chieu-dau-pha-khung-thuong-al.jpg");
        mangquangcao.add("https://thuvienanime.com/wp-content/uploads/2021/09/tan-vu.jpeg");
        mangquangcao.add("https://allimages.sgp1.digitaloceanspaces.com/tintapchicom/2021/01/VU-DONG-CAN-KHON-PHAN-4-PHIM-HOAT.jpg");

        //Th???c hi???n v??ng l???p for g??n ???nh v??o ImageView, r???i t??? imgView l??n app
        for (int i = 0; i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            //S??? d???ng h??m th?? vi???n Piscasso
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            // ph????ng th???c ch???nh t???m h??nh v???a khung qu???ng c??o
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            // Th??m ???nh t??? imageView v??o viewFillippepr
            viewFlipper.addView(imageView);
        }
        // thi???t l???p t??? ?????ng ch???y cho viewflipper ch???y trong 4 giay
        viewFlipper.setFlipInterval(2500);
        // run viewFlipper
        viewFlipper.setAutoStart(true);
        //G???i amindtion chop v??o v?? ra
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);

        //G???i Animation v??o viewFillipper
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setInAnimation(animation_slide_out);

        // run

    }

    // Ph????ng th???c ??nh x???
    private void AnhXa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewFlipper);
        listViewNew = findViewById(R.id.listviewNew);
        listView = findViewById(R.id.listviewmanhinhchinh);
        listViewThongTin = findViewById(R.id.listViewthongtin);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerlayout);

        TruyenArraylist = new ArrayList<>();

        Cursor cursor1 = databasedoctruyen.getData1();
        while (cursor1.moveToNext()){

            int id =  cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArraylist.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArraylist);
            listViewNew.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();

        //Th??ng tin
        taikhoanArrayList = new ArrayList<>();

        taikhoanArrayList.add(new Taikhoan(tentaikhoan,email));
        adapterthongtin = new adapterthongtin(this,R.layout.navigation_thongtin,taikhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);

        // chuy??n m???c
        chuyenmucArrayList = new ArrayList<>();

        chuyenmucArrayList.add(new chuyenmuc("????ng Truy???n", R.drawable.ic_add));
        chuyenmucArrayList.add(new chuyenmuc("Th??ng tin",R.drawable.ic_tt));
        chuyenmucArrayList.add(new chuyenmuc("????ng xu???t",R.drawable.ic_out));
        adapterchuyenmuc = new adapterchuyenmuc(this,R.layout.chuyenmuc,chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);
//        listView.setAdapter(adapterchuyenmuc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent =new Intent(MainActivity.this,manTimKiem.class);
                startActivity(intent);

                break;
            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}