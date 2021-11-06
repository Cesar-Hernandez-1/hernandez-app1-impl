package assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField newDescriptionTextBox;

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
