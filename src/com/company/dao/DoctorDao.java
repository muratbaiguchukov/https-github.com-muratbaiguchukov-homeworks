package com.company.dao;

import com.company.config.DatabaseConnection;
import com.company.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DoctorDao {
    private final static Connection conn = DatabaseConnection.connect();
    public int insertDoctor(Doctor doctor) {
    String SQL = "INSERT INTO doctor (id, fullname, opening_hours, phonenumber)" + "VALUES(?,?,?,?)";
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = conn.prepareStatement(SQL);
        preparedStatement.setInt(1, doctor.getId());
        preparedStatement.setString(2, doctor.getFullname());
        preparedStatement.setTime(3, doctor.getOpening_hours());
        preparedStatement.setString(4, doctor.getPhonenumber());
        return preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            preparedStatement.close();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    return 0;
}


    public int updateDoctor() {
        return 0;
    }

    public int deleteDoctor() {
        return 0;
    }

    public List<Doctor> selectDoctor() {
        return null;
    }
}
