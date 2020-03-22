package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.blujackkost.Model.DataKosModel;

import java.util.ArrayList;
import java.util.Calendar;

public class KostDetail extends AppCompatActivity {

    ImageView ivPhoto;
    TextView Name, Facility, Price, Description, Latitude, Longtitude,Date;
    Button btnBooking;
    Integer save;
    DatePickerDialog picker;

    private ArrayList<DataKosModel> list;

    void validate(){
        ivPhoto = findViewById(R.id.iv_Photo);
        Name = findViewById(R.id.tvNameKost);
        Facility = findViewById(R.id.tvFacility);
        Price = findViewById(R.id.tvPrice);
        Description = findViewById(R.id.tvDescription);
        Latitude = findViewById(R.id.tvLatitud);
        Longtitude = findViewById(R.id.tvLongtitud);
        btnBooking = findViewById(R.id.btnBooking);
        Date = findViewById(R.id.tvDatepik);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_detail);

        validate();

        list = new ArrayList<>();
        list.addAll(DataArray.getListData());

        Intent intent = getIntent();

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

        Glide.with(this)
                .load(R.drawable.kost4)
                .override(55, 55)
                .into(ivPhoto);

    }

    public void Booking(View view) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        picker = new DatePickerDialog(KostDetail.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Date.setText(dayOfMonth + "/" + (month + 1) + "/" +year);
            }
        },year, month, day);
        picker.show();
    }
}
