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
    static Scanner scan = new Scanner(System.in);


    // test
    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());

            switch (choose) {
                case 1 -> showStudents();
                case 2 -> insertStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> findStudent();
                case 6 -> System.out.println("Exit!!!");
                default -> System.out.println("Failed!!!");
            }
        } while(choose != 6);
    }

    static void showMenu() {
        System.out.println("1. Show Students");
        System.out.println("2. Insert");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Find");
        System.out.println("6. Exit");
        System.out.println("Choose: ");
    }


    public static void showStudents() {
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        Statement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("?", "root", "12345678");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "select * from student";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.createStatement();
            //B2.4: Lấy dữ liệu từ CSDL ra
            ResultSet resultSet = statement.executeQuery(sql);
            //B2.5: Đọc dữ liệu từ ResultSet => convert thành các object trong Java
            while(resultSet.next()) {
                Student stu = new Student(resultSet.getString("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birth"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("classObj"));
                stu.show();
                Main.student_list.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }


    // Insert
    private static void insertStudent() {
        Student student = new Student();
        student.input();

        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Link to Database
            conn = DriverManager.getConnection("?", "root", "12345678");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "insert into student(id, fullname, birth, gender, email, address, phone, classObj)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            //B2.2: Viết Java Truy vấn CSDL
            statement = conn.prepareCall(sql);
            statement.setString(1, student.getId());
            statement.setString(2, student.getFullname());
            statement.setString(3, student.getBirth());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhone());
            statement.setString(8,student.getClassObj());
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
    }


    // Update
    private static void updateStudent() {
        System.out.println("Sửa thông tin sinh viên theo MSV");
        Student student = new Student();
        student.input();

        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("?", "root", "12345678");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "update student set fullname = ?, birth = ?, gender = ?, email = ?, address = ?, phone = ?, classObj = ?"
                    + " where id = ?";
            //B2.2: Viết API Java Truy vấn CSDL
            statement = conn.prepareCall(sql);
            statement.setString(1, student.getFullname());
            statement.setString(2, student.getBirth());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getPhone());
            statement.setString(7, student.getClassObj());
            statement.setString(8, student.getId());
            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }


    // Delete
    private static void deleteStudent() {
        System.out.println("Nhập MSV cần xóa: ");
        String id = scan.nextLine();


        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("?", "root", "12345678");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "delete from student where id = ?";
            //B2.2: Viết API Java Truy vấn CSDL
            statement = conn.prepareCall(sql);
            statement.setInt(1, Integer.parseInt(id));
            //B2.4: Lấy dữ liệu từ CSDL ra
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }

    private static void findStudent() {
        System.out.println("Nhập sinh viên cần tìm kiếm: ");
        String fullname = scan.nextLine();

        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("?", "root", "12345678");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "select * from student where fullname like ?";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+fullname+"%");
            //B2.4: Lấy dữ liệu từ CSDL ra
            ResultSet resultSet = statement.executeQuery();
            //B2.5: Đọc dữ liệu từ ResultSet => convert thành các object trong Java
            while(resultSet.next()) {
                Student stu = new Student(resultSet.getString("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birth"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("classObj"));
                stu.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Finish Show Students
    }

}
