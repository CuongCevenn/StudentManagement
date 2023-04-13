package com.demo.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static Controller controller;
    public static List<Student> student_list = new ArrayList<Student>();

    @Override
    public void start(Stage stage) throws IOException {
//        CRUD.showStudents();
        for (int i = 0; i < 10; i++) {
            Student stu = new Student("20120118", "Nguyen Dinh Cuong", "25/11/2003", "Male",
                    "21020118@vnu.edu.vn", "Ha Noi", "0xxx251103", "K66CB");
            student_list.add(stu);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
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
