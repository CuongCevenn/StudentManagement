package com.demo.studentmanagement.ConnectToDatabase;

import com.demo.studentmanagement.Main;
import com.demo.studentmanagement.MainObject.Course;
import com.demo.studentmanagement.MainObject.Student;
import com.demo.studentmanagement.MainObject.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {
    public static String database;
    public static String user;
    public static String password;

    public static void showTeacher() {
        Main.teacher_list = new ArrayList<Teacher>();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(database, user, password);

//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            String sql = "select * from teacher order by id asc";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);
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
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);
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
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);
            String sql = "SELECT id FROM student;";

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Main.student_id_list.add(resultSet.getString("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String sql = "SELECT username, password FROM login;";

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Main.user_pass.put(resultSet.getString("username"), resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        Connection conn = null;
        Statement statement = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String sql = "select * from student order by id asc";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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

    public static void insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String sql = "insert into student(id, fullname, birthday, gender, email, address, phone, classObj)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, student.getId());
            statement.setString(2, student.getFullname());
            statement.setString(3, student.getBirth());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhone());
            statement.setString(8,student.getClassObj());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static void updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String sql = "update student set fullname = ?, birthday = ?, gender = ?, email = ?, address = ?, phone = ?, classObj = ?"
                    + " where id = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, student.getFullname());
            statement.setString(2, student.getBirth());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getPhone());
            statement.setString(7, student.getClassObj());
            statement.setString(8, student.getId());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("A student was updated successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static void deleteStudent(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String studentId = student.getId();
            String sql = "delete from student where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, studentId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static void findStudent(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management",
//                    "root", "");
            conn = DriverManager.getConnection(database, user, password);

            String studentId = student.getId();
            String sql = "select * from student where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                student.setId(resultSet.getString("id"));
                student.setFullname(resultSet.getString("fullname"));
                student.setBirth(resultSet.getString("birthday"));
                student.setGender(resultSet.getString("gender"));
                student.setEmail(resultSet.getString("email"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setClassObj(resultSet.getString("classObj"));
                System.out.println("Find successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

}
