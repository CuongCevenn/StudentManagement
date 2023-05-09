package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.Controller.LoginController;
import com.demo.studentmanagement.Controller.StudentController;
import com.demo.studentmanagement.Main;
import com.demo.studentmanagement.MainObject.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StudentFindController extends Controller {
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
    private TextField sId;
    @FXML
    private Label username;

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void loadLoginView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/login-view.fxml"));
        Parent root = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene.fxml"));
        Parent root = fxmlLoader.load();
        StudentController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    private void onAction(Student student) {
        name.setText(student.getFullname());
        gender.setText(student.getGender());
        dateOfBirth.setText(student.getBirth());
        sClass.setText(student.getClassObj());
        email.setText(student.getEmail());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
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
        String sId_ = sId.getText();
        if (Main.student_id_list.contains(sId_)) {
            thongBao.setText("Find successfully!");
            Student student = new Student(sId_);
            CRUD.findStudent(student);
            onAction(student);
        } else {
            thongBao.setText("SId is not exist!");
        }
    }
}
