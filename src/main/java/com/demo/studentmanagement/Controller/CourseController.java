package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.*;
import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.MainObject.Course;
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

public class CourseController extends Controller {
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

    public void loadStudentView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/student-scene.fxml"));
        Parent root = fxmlLoader.load();
        StudentController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    public void loadDetailView(String course) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/course-details-scene.fxml"));
        CourseDetailsController controller__ = new CourseDetailsController(course);
        fxmlLoader.setControllerFactory(c -> controller__);
        Parent root = fxmlLoader.load();
        CourseDetailsController controller = fxmlLoader.getController();
        controller.setUsername(Main.username);
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

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        loadLoginView();
    }

    @FXML
    protected void onStudentButtonClick() throws IOException {
        loadStudentView();
    }

    @FXML
    protected void onTeacherButtonClick() throws IOException {
        loadTeacherView();
    }

    @FXML
    private TableView<Course> table = new TableView<>();

    public void initialize() {
        TableColumn<Course, String> col1 = new TableColumn<>("Course_id");
        col1.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        TableColumn<Course, String> col2 = new TableColumn<>("Course_name");
        col2.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        table.getColumns().addAll(col1, col2);

        CRUD.showCourse();
        ObservableList<Course> data = FXCollections.observableArrayList(Main.course_list);
        table.setItems(data);
        System.out.println("3");

        table.setOnMouseClicked(event -> {
            Course selectedCourse = table.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                try {
                    loadDetailView(selectedCourse.getCourse_id());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("None data or bugs");
            }
        });
    }
}
