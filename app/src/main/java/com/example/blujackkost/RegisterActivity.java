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
import java.util.regex.Pattern;


import java.util.Calendar;

import static android.view.View.Z;

public class RegisterActivity extends AppCompatActivity {

    RadioGroup rgGender;
    RadioButton Male, Female;
    Button btnGetDate, Register;
    TextView tvDate;
    DatePickerDialog picker;
    EditText  etPicker, et_Username, et_Pass, etConfirmPass, etPhone;
    CheckBox checkbox;

    void validasi (){
        etPhone = findViewById(R.id.etPhoneNumber);
        Register = findViewById(R.id.btnRegis);
        et_Username = findViewById(R.id.et_username);
        et_Pass = findViewById(R.id.et_pass);
        etConfirmPass = findViewById(R.id.etComfrimPass);
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

    public void onClickRegisregis(View view) {

        if(et_Username.getText().toString().length()<3 || et_Username.getText().toString().length()>=25){
            et_Username.setText("Please input your username between 3 and 25 characters!");
        } else if (et_Username.getText().toString().length()==0){
            et_Username.setText("Username must be filled!");
        }else if (Pattern.compile("[A-Za-z0-9]").matcher(et_Username.getText().toString()).find()){
            et_Username.setText("username must contain at least 1 digit and alphabetic");
        }//kurang username unik

        if (et_Pass.getText().toString().length()==0){
            et_Pass.setText("Password must be filled!");
        } else if(et_Pass.getText().toString().length()<6){
            et_Pass.setText("Please input you password minimal 6 characters!");
        } else if(Pattern.compile(" (?=.*\\d)(?=.*[a-z])(?=.*[A-Z])").matcher(et_Pass.getText().toString()).find()){
            et_Pass.setText("password must contain at least 1 lowercase letter, 1 uppercase letter and 1 digit");
        }

        if(etConfirmPass.getText().toString().length()==0){
            etConfirmPass.setText("Password must be filled!");
        } else if(etConfirmPass.equals(et_Pass)){
            etConfirmPass.setText("Password no same");
        }

        if (etPhone.getText().toString().length()==0){
            etPhone.setText("Phone number be filled!");
        } else if(etPhone.getText().toString().length()<10 || etPhone.getText().toString().length()>=12){
            etPhone.setText("Please input your phone number between 10 and 12 character");
        } else if(Pattern.compile("[0-9]").matcher(etPhone.getText().toString()).find()){

        }

        if (rgGender.getCheckedRadioButtonId()==-1){
            // buat nampilin pesannya
        }

        //if (tvDate.)

      //  if()
    }
}
