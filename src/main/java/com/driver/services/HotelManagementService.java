package com.driver.services;

import com.driver.Repo.HotelManagementRepo;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelManagementService {

    @Autowired
    HotelManagementRepo hotelManagementRepo;


    public String addHotel(Hotel hotel) {
        if(hotel == null)
            return "FAILURE";

        return hotelManagementRepo.addHotel(hotel);
    }

    public String getHotelWithMostFacilities() {
        return hotelManagementRepo.getHotelWithMostFacilities();
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {

        Hotel hotel = hotelManagementRepo.getHotelbyHotelName(hotelName);
        HashSet<Facility> set = new HashSet<Facility>(newFacilities);
        List<Facility> oldFacilities = hotel.getFacilities();
        set.addAll(oldFacilities);
        hotel.setFacilities(new ArrayList<>(set));

        return hotelManagementRepo.updateFacilities(hotel);

    }
}
