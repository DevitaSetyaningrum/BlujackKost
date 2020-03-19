package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    RadioGroup rgGender;
    RadioButton Male, Female;
    Button btnGetDate;
    TextView tvDate;
    DatePickerDialog picker;
    EditText etPicker;
    CheckBox checkbox;

    void validasi (){
        rgGender = findViewById(R.id.rggGender);
        Male = findViewById(R.id.rbMale);
        Female = findViewById(R.id.rbFemale);
        btnGetDate = findViewById(R.id.btnPickDate);
        tvDate = findViewById(R.id.tvDate);
        etPicker = findViewById(R.id.etPicker);
        checkbox = findViewById(R.id.cbAgree);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        validasi();

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(Male.isChecked()){
                    Toast.makeText(RegisterActivity.this, "Male", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(RegisterActivity.this, "Female", Toast.LENGTH_SHORT).show();
                }
            }
        });


        etPicker.setInputType(InputType.TYPE_NULL);
        etPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // buat date picker dialog
                picker = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                etPicker.setText(dayOfMonth + "/" + (month + 1) + "/" +year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDate.setText("Selected Date: " + etPicker.getText());
            }
        });

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;

                if (cb.isChecked()){
                    Toast.makeText(RegisterActivity.this, "Agree", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
