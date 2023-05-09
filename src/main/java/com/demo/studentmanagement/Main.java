package com.demo.studentmanagement;

import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.MainObject.Course;
import com.demo.studentmanagement.MainObject.Student;
import com.demo.studentmanagement.MainObject.Teacher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main extends Application {
    private static Controller controller;
    public static List<Student> student_list = new ArrayList<Student>();
    public static List<Student> student_course_list = new ArrayList<Student>();
    public static List<Teacher> teacher_list = new ArrayList<Teacher>();
    public static List<String> student_id_list = new ArrayList<String>();
    public static Hashtable<String, String> user_pass = new Hashtable<String, String>();
    public static List<Course> course_list = new ArrayList<Course>();
    public static String username = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/demo/studentmanagement/login-view.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene scene = new Scene(root);
        stage.setTitle("Student management application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
