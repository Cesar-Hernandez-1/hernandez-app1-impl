/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class editDescriptionController {

    public void initData(String string){
        if(!string.isEmpty()){
            newDescriptionTextBox.setText(string);
        }
    }

    public String getDescription(){
        return newDescriptionTextBox.getText();
    }

    @FXML
    private TextArea newDescriptionTextBox;

    @FXML
    private Button saveDescriptionButton;

    @FXML
    void saveDescription(ActionEvent event) throws IOException {
        if(newDescriptionTextBox.getText().length() >= 1 && newDescriptionTextBox.getText().length() <= 256){
            Stage stage = (Stage) saveDescriptionButton.getScene().getWindow();
            stage.close();
        }else{
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DescriptionError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Description Length Error");
            stage.setScene(scene);
            stage.show();
        }
    }

}
