package com.demo.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {
    //    Bạn kết nối với database sau đó thực hiện các chức năng
    public void open() {
//        Ở đây bạn bắt đầu kết nối với database
    }

    public void close() {
//        Ở đây bạn đóng kết nối với database
    }


    private static void insertStudent() {
        Student student = new Student();
        student.input();

        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "insert into student(id, phone, fullname, birth, gender, email, address, classObj)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareCall(sql);
            statement.setInt(1, student.getId());
            statement.setInt(2, student.getPhone());
            statement.setString(3, student.getFullname());
            statement.setString(4, student.getBirth());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getAddress());
            statement.setString(8,student.getsClass());
            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

//    Sau đấy bạn cài đặt các chức năng kiểu như Create là thêm sinh viên vào csdl
//    Read là đọc dữ liệu tìm kiếm sv từ database ( câu truy vấn là câu lệnh select ấy)
//    Update, Delete
    }
}
