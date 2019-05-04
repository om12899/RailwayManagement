package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class detailsController {
    @FXML
    Button btnBack;
    @FXML
    public void setBtnBack(ActionEvent event)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookTrain.fxml"));

            Parent root1 = loader.load();


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Booking");
            window.setScene(new Scene(root1, 600, 400));
            window.show();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
