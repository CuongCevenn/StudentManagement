package com.demo.studentmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private Label thongBao;

    @FXML
    protected void onLoginButtonClick() {
        thongBao.setText("Your password is incorrect!");
    }
}
