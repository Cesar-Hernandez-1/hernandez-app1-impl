/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class dateChangerController {

    public String getNewDate(){
        return changeDatePicker.getValue().toString();
    }

    @FXML
    private DatePicker changeDatePicker;

    @FXML
    void updateDate(ActionEvent event) {
        Stage stage = (Stage) changeDatePicker.getScene().getWindow();
        stage.close();
    }
}
