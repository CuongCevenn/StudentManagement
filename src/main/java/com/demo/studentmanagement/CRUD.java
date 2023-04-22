package com.demo.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {
    // test
    public static void main(String[] args) {
//        int choose;
//
//        do {
//            showMenu();
//            choose = Integer.parseInt(scan.nextLine());
//
//            switch (choose) {
//                case 1 -> showStudents();
//                case 2 -> insertStudent();
//                case 3 -> updateStudent();
//                case 4 -> deleteStudent();
//                case 5 -> findStudent();
//                case 6 -> System.out.println("Exit!!!");
//                default -> System.out.println("Failed!!!");
//            }
//        } while(choose != 6);
//        Student student = new Student("20120118", "Nguyen Dinh Cuong", "25/11/2003", "Male",
//                "21020118@vnu.edu.vn", "Ha Noi", "0xxx251103", "K66CB");
//        insertStudent(student);
//        Student student = new Student("20120118");
//        findStudent(student);
//        System.out.println(student.toString());
    }

    public static void showTeacher() {
        Main.teacher_list = new ArrayList<Teacher>();
        Connection conn = null;
        Statement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "select * from teacher";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.createStatement();
            //B2.4: Lấy dữ liệu từ CSDL ra
            ResultSet resultSet = statement.executeQuery(sql);
            //B2.5: Đọc dữ liệu từ ResultSet => convert thành các object trong Java
            while(resultSet.next()) {
                Teacher teacher = new Teacher(resultSet.getString("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birth"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("quali"),
                        resultSet.getString("exper"),
                        resultSet.getString("achie"));
                Main.teacher_list.add(teacher);
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
    }

    public static void showCourse() {
        Main.course_list = new ArrayList<Course>();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");
            String sql = "SELECT DISTINCT course_id, name_course FROM course";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Course course = new Course(resultSet.getString("course_id"),
                        resultSet.getString("name_course"));
                Main.course_list.add(course);
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
    }

    public static void showCourseDetails(String course) {
        Main.student_course_list = new ArrayList<Student>();
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");
            String sql = "SELECT student.* FROM student JOIN course ON student.id = course.student_id WHERE course.course_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, course);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student stu = new Student(resultSet.getString("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("classObj"));
                stu.show();
                Main.student_course_list.add(stu);
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
    }

    public static void getStudentId() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            String sql = "SELECT id FROM student;";

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Main.student_id_list.add(resultSet.getString("id"));
            }
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

    public static void getUserPass() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            String sql = "SELECT username, password FROM login;";

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Main.user_pass.put(resultSet.getString("username"), resultSet.getString("password"));
            }
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

    public static void showStudents() {
        Main.student_list = new ArrayList<Student>();
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        Statement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

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
                        resultSet.getString("birthday"),
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
    public static void insertStudent(Student student) {
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Link to Database
//            conn = DriverManager.getConnection("?", "root", "12345678");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "insert into student(id, fullname, birthday, gender, email, address, phone, classObj)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            //B2.2: Viết Java Truy vấn CSDL
            statement = conn.prepareStatement(sql);
            statement.setString(1, student.getId());
            statement.setString(2, student.getFullname());
            statement.setString(3, student.getBirth());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhone());
            statement.setString(8,student.getClassObj());
            //B2.4: Lấy dữ liệu từ CSDL ra
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
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
    public static void updateStudent(Student student) {
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "update student set fullname = ?, birthday = ?, gender = ?, email = ?, address = ?, phone = ?, classObj = ?"
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
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("A student was updated successfully!");
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

    // Delete
    public static void deleteStudent(Student student) {
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");
            String studentId = student.getId();
            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String sql = "delete from student where id = ?";
            //B2.2: Viết API Java Truy vấn CSDL
            statement = conn.prepareStatement(sql);
            statement.setString(1, studentId);
            //B2.4: Lấy dữ liệu từ CSDL ra
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
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

    public static void findStudent(Student student) {
        //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //B1. Tạo kết nối tới CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
                    "root", "");

            //B2. Tạo 1 truy vấn tới CSDL
            //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
            String studentId = student.getId();
            String sql = "select * from student where id = ?";
            //B2.2: Viết API Java Trúy vấn CSDL
            statement = conn.prepareStatement(sql);
            statement.setString(1, studentId);
            //B2.4: Lấy dữ liệu từ CSDL ra
            ResultSet resultSet = statement.executeQuery();
            //B2.5: Đọc dữ liệu từ ResultSet => convert thành các object trong Java
            while(resultSet.next()) {
                student.setId(resultSet.getString("id"));
                student.setFullname(resultSet.getString("fullname"));
                student.setBirth(resultSet.getString("birthday"));
                student.setGender(resultSet.getString("gender"));
                student.setEmail(resultSet.getString("email"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setClassObj(resultSet.getString("classObj"));
//                System.out.println(student.toString());
                System.out.println("Find successfully!");
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
