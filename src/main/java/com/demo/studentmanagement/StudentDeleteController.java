package com.demo.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StudentDeleteController extends StudentController {
    @FXML
    private Label name;
    @FXML
    private Label gender;
    @FXML
    private Label dateOfBirth;
    @FXML
    private Label sClass;
    @FXML
    private Label email;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label thongBao;
    @FXML
    private TextField sID;

    public void loadLoginView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Parent root = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student-scene.fxml"));
        Parent root = fxmlLoader.load();
        StudentController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        loadLoginView();
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        loadStudentScene();
    }

    @FXML
    protected void onFindButtonClick() throws IOException {
        String sID_ = sID.getText();
        System.out.println(sID_);
    }
}
