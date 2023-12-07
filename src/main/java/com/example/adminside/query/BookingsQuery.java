package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;
import com.example.adminside.model.UserBookingsModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingsQuery {

    public List<UserBookingsModel> getUserBookings (int id) {
        List<UserBookingsModel> userBookings = new ArrayList<>();
        String query = "SELECT * FROM newbookings WHERE bookedById = ?";

        try {
            PreparedStatement preparedStatement = new DBConnection().getStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int bookingID = resultSet.getInt("bookingID");
                String bookingDate = resultSet.getString("bookedDate");
                String bookedBy = resultSet.getString("bookedBy");
                String bookedFor = resultSet.getString("bookedFor");
                String bookingStartTime = resultSet.getString("bookStartTime");
                String bookingEndTime = resultSet.getString("bookEndTime");
                int bookedById = resultSet.getInt("bookedById");
                String price = resultSet.getString("price");
                String payment = resultSet.getString("payment");
                userBookings.add(new UserBookingsModel(bookingID, bookingDate, bookedBy, bookingStartTime, bookingEndTime, bookedFor, bookedById, price, payment));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userBookings;


    }
}
