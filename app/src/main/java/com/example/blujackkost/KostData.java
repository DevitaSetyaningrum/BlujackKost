package com.example.blujackkost;

import java.util.ArrayList;

public class KostData {

    public  static String [][] data = new String [][]{
            {"Maharaja", "1450000", "Ac, WiFi, Bathroom", R.drawable.kost3+"", "The best boarding", "-6.2000809", "106.7833355"},
            {"Haji Indra", "1900000", "AC, WiFI", R.drawable.kost4+"", "The cheapest boarding", "-6.2261741", "106.9078293"}
    };

    public  static ArrayList<Kost> getListData(){
        Kost kost = null;
        ArrayList<Kost> list= new ArrayList<>();
        for (int i=0; i<data.length; i++){
            kost=new Kost();
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
}
