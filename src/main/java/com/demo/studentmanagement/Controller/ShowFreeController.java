package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Abstract.Controller;
import com.demo.studentmanagement.ConnectToDatabase.CRUD;
import com.demo.studentmanagement.Main;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ShowFreeController extends Controller {
    @FXML
    private TableView<Student> table = new TableView<Student>();
    @FXML
    private TextField database;
    @FXML
    private Label total;

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

        CRUD.database = "jdbc:mysql://" + "b01hoclhjzrpew31hgwy-mysql.services.clever-cloud.com:3306/b01hoclhjzrpew31hgwy";
        CRUD.user = "u2okupq8mcizghwm";
        CRUD.password = "bln2dFKcRnCxWZ0Y6CTQ";
        CRUD.showStudents();
        ObservableList<Student> data = FXCollections.observableArrayList(Main.student_list);
        table.setItems(data);
        total.setText(String.valueOf(Main.student_list.size()));
        System.out.println("1");
    }

    public void loadLoginView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/demo/studentmanagement/login-view.fxml"));
        Parent root = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(root);
    }

    @FXML
    protected void onBackToLoginButton() throws IOException {
        loadLoginView();
    }
}
