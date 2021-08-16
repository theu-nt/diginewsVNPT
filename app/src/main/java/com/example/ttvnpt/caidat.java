package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import DAO.DataLocalManager;
import adapter.IClickListener;

public class caidat extends AppCompatActivity {
TextView tvtindp,tvchuyenMuc,tvtinDPChon;
Toolbar toolbar;
ArrayList<String> arrayList=new ArrayList<>();
//SharedPreferences sharedPreferences;
chonDPBottomSheet chonDPBottomSheet;
    String dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);

        tvtindp=findViewById(R.id.tvtindiaphuong);
        toolbar=findViewById(R.id.toolbarcaidat);
        tvchuyenMuc=findViewById(R.id.chuyenmuc);
        tvtinDPChon=findViewById(R.id.tvdiaphuong);

        if(DataLocalManager.getFirstInstall()!=null){
            dp=DataLocalManager.getFirstInstall();
            tvtinDPChon.setText(dp);
            //DataLocalManager.setFirstInstall("aa");
        }
        else{
            tvtinDPChon.setText("");
        }

//        sharedPreferences=getSharedPreferences("tindp",MODE_PRIVATE);
//        dp=sharedPreferences.getString("diaphuongchon","");
//        tvtinDPChon.setText(dp);
//        if(!dp.equals("")) {
//            chonDPBottomSheet.setData(dp);
//        }


        tvchuyenMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(caidat.this,danhmuc.class);
                startActivity(intent);
            }
        });


        arrayList.add("Thái Bình");
        arrayList.add("Hà Nội");
        arrayList.add("Hải Phòng");
        arrayList.add("Quảng Ninh");
        arrayList.add("Đà Nẵng");
        arrayList.add("Bắc Giang");
        arrayList.add("Quảng Nam");
        arrayList.add("Bình Dương");
        arrayList.add("Nghệ An");
        arrayList.add("Nam Định");
        arrayList.add("Hòa Bình");



        ActionToolbar();

        tvtindp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chonDPBottomSheet=new chonDPBottomSheet(arrayList, new IClickListener() {
                    @Override
                    public void clickIem(String string) {
                        Toast.makeText(caidat.this,string,Toast.LENGTH_LONG).show();
                        DataLocalManager.setFirstInstall(string);
                        //SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putString("diaphuongchon",string);
//                        editor.commit();

                        dp=DataLocalManager.getFirstInstall();
                        tvtinDPChon.setText(dp);

                    }
                });
                chonDPBottomSheet.show(getSupportFragmentManager(),chonDPBottomSheet.getTag());

            }
        });
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}