package com.demo.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class StudentAddController extends Controller {
    @FXML
    private ChoiceBox<String> addChoiceBox;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField studentId;
    @FXML
    private TextField name;
    @FXML
    private TextField class_;
    @FXML
    private Label label1;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;

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

    private void addAction(Student student) {
        String selectedOption = addChoiceBox.getSelectionModel().getSelectedItem().toString();
        LocalDate selectedDate = dateOfBirth.getValue();
        String sId = studentId.getText();
        String sName = name.getText();
        String sClass = class_.getText();
        String sEmail = email.getText();
        String sPhone = phone.getText();
        String sAddress = address.getText();
        student.setId(sId);
        student.setFullname(sName);
        student.setBirth(selectedDate.toString());
        student.setGender(selectedOption);
        student.setEmail(sEmail);
        student.setAddress(sAddress);
        student.setPhone(sPhone);
        student.setClassObj(sClass);
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
    protected void onCheckButtonClick() throws IOException {
        if (false) {
            label1.setText("Student ID exist");
        } else {
            label1.setText("OK");
        }
    }

    @FXML
    protected void onAddButtonClick() throws IOException {
        Student student = new Student();
        addAction(student);
        CRUD.insertStudent(student);
        System.out.println(student.toString());
    }
}
