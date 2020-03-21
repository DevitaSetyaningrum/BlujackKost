package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        String Name = list.get(save).getName();
        String Facility = list.get(save).getFacility();
        String Price = list.get(save).getPrice();
        String Description = list.get(save).getDescription();
        String Latitude = list.get(save).getLatitude();
        String Longtitude = list.get(save).getLongtitude();
        String ivPhoto = list.get(save).getPhoto();
        startActivity(intent);

    }
}
