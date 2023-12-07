package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckImageQuery {
    public static boolean checkImg (int id) {
        boolean hasImg = false;
        String query = "SELECT img FROM organisation WHERE userId = ? AND img IS NULL";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hasImg = false;
            } else {
                hasImg = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  hasImg;
    }
}
