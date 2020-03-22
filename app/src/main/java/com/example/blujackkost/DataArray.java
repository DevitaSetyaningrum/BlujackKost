package com.example.blujackkost;

import com.example.blujackkost.Model.DataBookingModel;
import com.example.blujackkost.Model.DataKosModel;

import java.util.ArrayList;

public class DataArray {

    public  static String [][] data = new String [][]{
            {"Maharaja", "1450000", "Ac, WiFi, Bathroom", R.drawable.kost3+"", "The best boarding", "-6.2000809", "106.7833355"},
            {"Haji Indra", "1900000", "AC, WiFI", R.drawable.kost4+"", "The cheapest boarding", "-6.2261741", "106.9078293"}
    };

    public static String[] databooking = new String[]{
      ""
    };

    public  static ArrayList<DataKosModel> getListData(){
        DataKosModel kost = null;
        ArrayList<DataKosModel> list= new ArrayList<>();
        for (int i=0; i<data.length; i++){
            kost=new DataKosModel();
            kost.setName(data[i][0]);
            kost.setPrice(data[i][1]);
            kost.setFacility(data[i][2]);
            kost.setPhoto(data[i][3]);
            kost.setDescription(data[i][4]);
            kost.setLatitude(data[i][5]);
            kost.setLongtitude(data[i][6]);

            list.add(kost);
        }
        return list;
    }

    public static ArrayList<DataBookingModel> getListDataBooking(){
        DataBookingModel booking = null;
        ArrayList<DataBookingModel> listBooking = new ArrayList<>();
        for(int i=0; i<databooking.length; i++){
            booking = new DataBookingModel();
            booking.setDate(databooking[0]);

            listBooking.add(booking);

        }

        return listBooking;
    }


}
