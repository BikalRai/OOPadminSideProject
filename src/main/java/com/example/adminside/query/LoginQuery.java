package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;
import com.example.adminside.model.EmpModel;
import com.example.adminside.model.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQuery {

    public static EmpModel getUser (String username, String password) {
        EmpModel emp = new EmpModel();
        String query = "SELECT * FROM organisation WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                emp.setEmpId(resultSet.getInt("empId"));
                emp.setFullName(resultSet.getString("fullname"));
                emp.setUsername(resultSet.getString("username"));
                emp.setPassword(resultSet.getString("password"));
                emp.setRole(resultSet.getString("role"));
                emp.setMobile(resultSet.getString("mobile"));
                emp.setEmail(resultSet.getString("email"));
                emp.setJoinDate(resultSet.getString("joinDate"));
                emp.setStatus(resultSet.getString("status"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

}
