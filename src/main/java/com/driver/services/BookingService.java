package com.driver.services;

import com.driver.Repo.BookingRepo;
import com.driver.Repo.HotelManagementRepo;
import com.driver.Repo.UserRepo;
import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    HotelManagementRepo hotelManagementRepo;

    @Autowired
    UserRepo userRepo;

    public int bookARoom(Booking booking) {
       Hotel hotel = hotelManagementRepo.getHotelbyHotelName(booking.getHotelName());
       if(booking.getNoOfRooms() > hotel.getAvailableRooms())
           return -1;
       int total = booking.getNoOfRooms() * hotel.getPricePerNight();
       booking.setAmountToBePaid(total);
       Booking savedBooking =  bookingRepo.bookARoom(booking);
       return savedBooking.getAmountToBePaid();

    }

    public int getBookings(Integer aadharCard) {
        return bookingRepo.getBookings(aadharCard);
    }
}
