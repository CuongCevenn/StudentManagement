module com.demo.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.demo.studentmanagement to javafx.fxml;
    exports com.demo.studentmanagement;
}