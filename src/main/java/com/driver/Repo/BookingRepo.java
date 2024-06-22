package com.driver.Repo;

import com.driver.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class BookingRepo {

    HashMap<String, Booking> bookingDB = new HashMap<>();

    public Booking bookARoom(Booking booking) {
        String randonID = UUID.randomUUID().toString();

       return bookingDB.put(randonID, booking);

    }

    public int getBookings(Integer aadharCard) {
        for(Booking booking : bookingDB.values()){
            if(booking.getBookingAadharCard() == (aadharCard))
                return booking.getNoOfRooms();
        }

        return -1;
    }
}
