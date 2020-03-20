package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCategory;
    private ArrayList<Kost> list;
    ListKostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(KostData.getListData());

        showRecyclerList();

    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKostAdapter listKostAdapter = new ListKostAdapter(this);
        listKostAdapter. setListKost(list);
        rvCategory.setAdapter(listKostAdapter);

        adapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void onItemClick(int pos) {

                Toast.makeText(MainActivity.this,"Clicked Item Is : " + list.get(pos),
                        Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, KostDetail.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.action_Booking:
                Toast.makeText(MainActivity.this, "Booking", Toast.LENGTH_SHORT).show();
                //  Buat semua action
                break;

            case R.id.action_logout:
                Toast.makeText(MainActivity.this, "Log out", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);

    }
}
