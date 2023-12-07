package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountQuery {
    public static int getUserCount () {
        int count = 0;

        String query = "SELECT COUNT(*) AS user_count from users";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("user_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getBookingsCount () {
        int count = 0;
        String query = "SELECT COUNT(*) AS bookings_count FROM newbookings WHERE payment <> 'pending'";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("bookings_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getPendingCount () {
        int count = 0;
        String query = "SELECT COUNT(*) AS pending_count FROM newbookings WHERE payment = 'pending'";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("pending_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
