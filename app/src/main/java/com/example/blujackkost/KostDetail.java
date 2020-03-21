package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class KostDetail extends AppCompatActivity {

    ImageView ivPhoto;
    TextView Name, Facility, Price, Description, Latitude, Longtitude;
    Button btnBooking;
    Integer save;

    private ArrayList<Kost> list;

    void validate(){
        ivPhoto = findViewById(R.id.iv_Photo);
        Name = findViewById(R.id.tvNameKost);
        Facility = findViewById(R.id.tvFacility);
        Price = findViewById(R.id.tvPrice);
        Description = findViewById(R.id.tvDescription);
        Latitude = findViewById(R.id.tvLatitud);
        Longtitude = findViewById(R.id.tvLongtitud);
        btnBooking = findViewById(R.id.btnBooking);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_detail);

        validate();

        list = new ArrayList<>();
        list.addAll(KostData.getListData());

        Intent intent = getIntent();
        //String
        save = intent.getIntExtra("pos", 0);
        String strName = list.get(save).getName();
        String strFacility = list.get(save).getFacility();
        String strPrice = list.get(save).getPrice();
        String strDescription = list.get(save).getDescription();
        String strLatitude = list.get(save).getLatitude();
        String strLongtitude = list.get(save).getLongtitude();
        String strivPhoto = list.get(save).getPhoto();
        startActivity(intent);

        Name.setText(strName);
        Facility.setText(strFacility);
        Price.setText(strPrice);
        Description.setText(strDescription);
        Latitude.setText(strLatitude);
        Longtitude.setText(strLongtitude);
//
//        Glide.with(this)
//                .load(R.drawable.kost4)
//                .override(55, 55)
//                .into(ivPhoto);

    }
}
