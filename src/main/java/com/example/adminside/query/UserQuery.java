package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;
import com.example.adminside.model.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserQuery {
    public static List<UserModel> getAllUsers () {
        List <UserModel> allUsers = new ArrayList<>();

        String query = "select * from users";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("userID"));
                userModel.setFullName(resultSet.getString("fullname"));
                userModel.setMobile(resultSet.getString("mobile"));
                userModel.setPassword(resultSet.getString("password"));
                userModel.setBookings(resultSet.getInt("bookings"));
                allUsers.add(userModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
