package com.example.blujackkost;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.blujackkost.Model.DataBookingModel;
import com.example.blujackkost.Model.DataKosModel;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    RecyclerView rvBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        rvBooking = findViewById(R.id.rv_booking);
        rvBooking.setHasFixedSize(false);


        if(DataArray.dataBooking.isEmpty()){
            // terserah lah isi apa
        }
        else{
            showRecyclerList();
        }

    }

    public void showAlertDialogButtonClicked(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to cancel this booking?");
        // add the buttons
        builder.setPositiveButton("NO", null);
        builder.setNegativeButton("YES", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showRecyclerList() {
        rvBooking.setLayoutManager(new LinearLayoutManager(this));
        ListBookingAdapter listBookingAdapter = new ListBookingAdapter(this,DataArray.dataBooking);
        rvBooking.setAdapter(listBookingAdapter);

        listBookingAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void onItemClick(int pos) {
                showAlertDialogButtonClicked(View);
            }
        });
    }
}
