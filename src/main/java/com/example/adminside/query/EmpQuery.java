package com.example.adminside.query;

import com.example.adminside.connection.DBConnection;
import com.example.adminside.model.EmpModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpQuery {

    public static void createEmp (EmpModel emp) {
        String query = "INSERT INTO organisation (fullname, username, password, role, mobile, email, joinDate, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setString(1, emp.getFullName());
            preparedStatement.setString(2, emp.getUsername());
            preparedStatement.setString(3, emp.getPassword());
            preparedStatement.setString(4, emp.getRole());
            preparedStatement.setString(5, emp.getMobile());
            preparedStatement.setString(6, emp.getEmail());
            preparedStatement.setString(7, emp.getJoinDate());
            preparedStatement.setString(8, emp.getStatus());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static EmpModel getEmp(String username) {
        String query = "select * from organisation where username = ?";
        EmpModel emp = new EmpModel();

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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

    public static boolean empExists (String email) {
        boolean empExist = false;
        String query = "SELECT * FROM organisation where email = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                empExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empExist;
    }


    public static List<EmpModel> getAllEmp () {
        List<EmpModel> allEmp = new ArrayList<>();
        String query = "SELECT * FROM organisation where role != 'admin'";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmpModel empModel = new EmpModel();

                empModel.setEmpId(resultSet.getInt("empId"));
                empModel.setFullName(resultSet.getString("fullname"));
                empModel.setUsername(resultSet.getString("username"));
                empModel.setPassword(resultSet.getString("password"));
                empModel.setRole(resultSet.getString("role"));
                empModel.setMobile(resultSet.getString("mobile"));
                empModel.setEmail(resultSet.getString("email"));
                empModel.setJoinDate(resultSet.getString("joinDate"));
                empModel.setStatus(resultSet.getString("status"));

                allEmp.add(empModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allEmp;
    }

    public static String getStoredHashedPassword (String username) {
        String password = null;
        String query = "select password from organisation where username = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }

    public static void setPassword(String password, String username) {
        String query = "update organisation set password = ? where username = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<EmpModel> getAllEmpNotAdmin(String username) {
        List<EmpModel> allEmp = new ArrayList<>();
        String query = "select * from organisation where role != 'admin' and username != ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmpModel emp = new EmpModel();
                emp.setFullName(resultSet.getString("fullname"));
                emp.setUsername(resultSet.getString("username"));
                emp.setPassword(resultSet.getString("password"));
                emp.setRole(resultSet.getString("role"));
                emp.setMobile(resultSet.getString("mobile"));
                emp.setEmail(resultSet.getString("email"));
                emp.setJoinDate(resultSet.getString("joinDate"));
                emp.setStatus(resultSet.getString("status"));

                allEmp.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allEmp;
    }

    public static void updateEmp (EmpModel emp) {
        EmpModel empModel = new EmpModel();
        String query = "update organisation set fullname = ?, username = ?, password= ?, role = ?, mobile = ?, email = ?, joinDate = ?, status = ? where empId = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, emp.getFullName());
            preparedStatement.setString(2, emp.getUsername());
            preparedStatement.setString(3, emp.getPassword());
            preparedStatement.setString(4, emp.getRole());
            preparedStatement.setString(5, emp.getMobile());
            preparedStatement.setString(6, emp.getEmail());
            preparedStatement.setString(7, emp.getJoinDate());
            preparedStatement.setString(8, emp.getStatus());
            preparedStatement.setInt(9, emp.getEmpId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
