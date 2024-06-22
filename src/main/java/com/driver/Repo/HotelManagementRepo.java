package com.driver.Repo;

import com.driver.model.Facility;
import com.driver.model.Hotel;

import java.util.*;

public class HotelManagementRepo {

    HashMap<String, Hotel> hotelDB = new HashMap<>();


    public String addHotel(Hotel hotel) {
        // Generate a random UUID
        if(hotelDB.containsKey(hotel.getHotelName()))
            return "FAILURE";

        hotelDB.put(hotel.getHotelName(), hotel);
        return "SUCCESS";
    }

    public String getHotelWithMostFacilities() {
        int mx = 0;
        String name="";
        for(Hotel h : hotelDB.values()){
            List<Facility> facilities = h.getFacilities();
            if(facilities.size() > mx){
                mx = facilities.size();
                name = h.getHotelName();
            }
        }
        return name;
    }


    public Hotel getHotelbyHotelName(String hotelName) {
        return hotelDB.get(hotelName);
    }


    public Hotel updateFacilities(Hotel hotel) {
//        HashSet<Facility> set = new HashSet<Facility>(newFacilities);
//        List<Facility> oldFacilities = hotel.getFacilities();
//        set.addAll(oldFacilities);
//        hotel.setFacilities(new ArrayList<>(set));
        return hotelDB.put(hotel.getHotelName(), hotel);
    }
}
