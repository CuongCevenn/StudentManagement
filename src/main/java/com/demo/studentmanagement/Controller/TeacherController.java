package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.Controller.CourseController;
import com.demo.studentmanagement.Controller.LoginController;
import com.demo.studentmanagement.Controller.StudentController;
import com.demo.studentmanagement.Main;
import com.demo.studentmanagement.MainObject.Teacher;
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

public class TeacherController extends Controller {
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

    public void loadStudentView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene.fxml"));
        Parent root = fxmlLoader.load();
        StudentController controller = fxmlLoader.getController();
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

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        loadLoginView();
    }

    @FXML
    protected void onStudentButtonClick() throws IOException {
        loadStudentView();
    }

    @FXML
    protected void onCourseButtonClick() throws IOException {
        loadCourseView();
    }

    @FXML
    private TableView<Teacher> table = new TableView<>();

    public void initialize() {
        TableColumn<Teacher, String> col1 = new TableColumn<>("TeacherID");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Teacher, String> col2 = new TableColumn<>("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        TableColumn<Teacher, String> col3 = new TableColumn<>("Birth");
        col3.setCellValueFactory(new PropertyValueFactory<>("birth"));
        TableColumn<Teacher, String> col4 = new TableColumn<>("Gender");
        col4.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Teacher, String> col5 = new TableColumn<>("Email");
        col5.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Teacher, String> col6 = new TableColumn<>("Address");
        col6.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Teacher, String> col7 = new TableColumn<>("Phone");
        col7.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Teacher, String> col8 = new TableColumn<>("Qualification");
        col8.setCellValueFactory(new PropertyValueFactory<>("quali"));
        TableColumn<Teacher, String> col9 = new TableColumn<>("Experience");
        col9.setCellValueFactory(new PropertyValueFactory<>("exper"));
        TableColumn<Teacher, String> col10 = new TableColumn<>("Achieve");
        col10.setCellValueFactory(new PropertyValueFactory<>("achie"));
        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10);

        CRUD.showTeacher();
        ObservableList<Teacher> data = FXCollections.observableArrayList(Main.teacher_list);
        table.setItems(data);
        total.setText(String.valueOf(Main.teacher_list.size()));
        System.out.println("7");
    }
}
