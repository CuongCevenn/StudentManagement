module com.demo.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.demo.studentmanagement to javafx.fxml;
    exports com.demo.studentmanagement;
    exports com.demo.studentmanagement.Abstract;
    opens com.demo.studentmanagement.Abstract to javafx.fxml;
    exports com.demo.studentmanagement.MainObject;
    opens com.demo.studentmanagement.MainObject to javafx.fxml;
    exports com.demo.studentmanagement.ConnectToDatabase;
    opens com.demo.studentmanagement.ConnectToDatabase to javafx.fxml;
    exports com.demo.studentmanagement.Controller;
    opens com.demo.studentmanagement.Controller to javafx.fxml;
}