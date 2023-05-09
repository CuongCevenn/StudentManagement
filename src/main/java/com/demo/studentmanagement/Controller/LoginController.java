package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends Controller {
    @FXML
    private Label thongBao;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField database;
    @FXML
    private TextField userDB;
    @FXML
    private TextField passDB;

    @FXML
    private void addActionListener() {
        usernameField.setOnAction(e -> {
            String username = usernameField.getText();
            // Code xử lý dữ liệu tại đây
            System.out.println(username);
        });

        passwordField.setOnAction(e -> {
            String password = passwordField.getText();
            // Code xử lý dữ liệu tại đây
            System.out.println(password);
        });
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        CRUD.database = "jdbc:mysql://" + database.getText();
        CRUD.user = userDB.getText();
        CRUD.password = passDB.getText();
        CRUD.getUserPass();
        CRUD.getStudentId();
        if (Main.user_pass.containsKey(username)) {
            if (Main.user_pass.get(username).equals(password)) {
                Main.username = username;
                loadStudentScene();
            } else {
                System.out.println("Password is incorrect");
                thongBao.setText("Password is incorrect!");
            }
        } else {
            thongBao.setText("Username doesn't exist");
        }
    }

    public void loadStudentScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene.fxml"));
        Parent root = fxmlLoader.load();
        StudentController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
//        stage.setScene(scene);
    }

    public void loadShowStudentScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/show-student.fxml"));
        Parent root = fxmlLoader.load();
        ShowFreeController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    protected void onShowWithoutLoginButton() throws IOException {
        loadShowStudentScene();
    }
}
