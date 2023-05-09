package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.*;
import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.MainObject.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class StudentController extends Controller {
    @FXML
    private Label username;
    @FXML
    private Label total;

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

    public void loadTeacherView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/teacher-scene.fxml"));
        Parent root = fxmlLoader.load();
        TeacherController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadCourseView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/course-scene.fxml"));
        Parent root = fxmlLoader.load();
        CourseController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentAddView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene-add.fxml"));
        Parent root = fxmlLoader.load();
        StudentAddController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentFindView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene-find.fxml"));
        Parent root = fxmlLoader.load();
        StudentFindController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentUpdateView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene-update.fxml"));
        Parent root = fxmlLoader.load();
        StudentUpdateController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadStudentDeleteView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene-delete.fxml"));
        Parent root = fxmlLoader.load();
        StudentDeleteController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        loadLoginView();
    }

    @FXML
    protected void onAddButtonClick() throws IOException {
        loadStudentAddView();
    }

    @FXML
    protected void onFindButtonClick() throws IOException {
        loadStudentFindView();
    }

    @FXML
    protected void onUpdateButtonClick() throws IOException {
        loadStudentUpdateView();
    }

    @FXML
    protected void onDeleteButtonClick() throws IOException {
        loadStudentDeleteView();
    }

    @FXML
    protected void onTeacherButtonClick() throws IOException {
        loadTeacherView();
    }

    @FXML
    protected void onCourseButtonClick() throws IOException {
        loadCourseView();
    }

    @FXML
    private TableView<Student> table = new TableView<>();

    public void initialize() {
        TableColumn<Student, String> col1 = new TableColumn<>("SID");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Student, String> col2 = new TableColumn<>("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        TableColumn<Student, String> col3 = new TableColumn<>("Birth");
        col3.setCellValueFactory(new PropertyValueFactory<>("birth"));
        TableColumn<Student, String> col4 = new TableColumn<>("Gender");
        col4.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Student, String> col5 = new TableColumn<>("Email");
        col5.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Student, String> col6 = new TableColumn<>("Address");
        col6.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Student, String> col7 = new TableColumn<>("Phone");
        col7.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Student, String> col8 = new TableColumn<>("Class");
        col8.setCellValueFactory(new PropertyValueFactory<>("classObj"));
        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8);

        CRUD.showStudents();
        ObservableList<Student> data = FXCollections.observableArrayList(Main.student_list);
        table.setItems(data);
        total.setText(String.valueOf(Main.student_list.size()));
        System.out.println("1");
    }
}
