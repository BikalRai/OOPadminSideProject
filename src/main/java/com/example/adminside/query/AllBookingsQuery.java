package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;
import com.example.adminside.model.BookingModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllBookingsQuery {
    public static List<BookingModel> getAllBookings () {
        List <BookingModel> bookings = new ArrayList<>();
        String query = "SELECT * FROM newbookings";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookingModel booking = new BookingModel();

                booking.setBookingID(resultSet.getInt("bookingID"));
                booking.setBookingDate(resultSet.getString("bookedDate"));
                booking.setBookedBy(resultSet.getString("bookedBy"));
                booking.setBookedFor(resultSet.getString("bookedFor"));
                booking.setBookingStart(resultSet.getString("bookStartTime"));
                booking.setBookingEnd(resultSet.getString("bookEndTime"));
                booking.setBookedById(resultSet.getInt("bookedById"));
                booking.setPrice(resultSet.getString("price"));
                booking.setPayment(resultSet.getString("payment"));

                bookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}
