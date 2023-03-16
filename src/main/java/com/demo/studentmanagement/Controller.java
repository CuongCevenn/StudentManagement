package com.demo.studentmanagement;

import javafx.stage.Stage;

public abstract class Controller {
    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
