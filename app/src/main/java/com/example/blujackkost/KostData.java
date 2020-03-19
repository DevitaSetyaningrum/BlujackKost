package com.example.blujackkost;

import java.util.ArrayList;

public class KostData {

    public  static String [][] data = new String [][]{
            {"Maharaja", "1450000", "Ac, WiFi, Bathroom", "https://id.pinterest.com/pin/756886281099389951/"},
            {"Haji Indra", "1900000", "AC, WiFI", "https://id.pinterest.com/pin/766104586583582266/"},
            {"Haji Indra", "1900000", "AC, WiFI", "https://id.pinterest.com/pin/797418677746230200/"},
            {"Haji Indra", "1900000", "AC, WiFI", "https://id.pinterest.com/pin/513621532494309951/"},
            {"Haji Indra", "1900000", "AC, WiFI", "https://id.pinterest.com/pin/766104586583582266/"}


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

            list.add(kost);

        }

        return list;
    }
}
