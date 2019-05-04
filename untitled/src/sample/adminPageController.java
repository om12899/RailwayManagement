package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class adminPageController {
    @FXML
    Button cancelTicket;
    @FXML
    Button bookTicket;
    @FXML
    Button logout;
    @FXML
    Button searchTrain;

    public void setSearchTrain(ActionEvent event)
    {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("searchTrain.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Search Train");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void setCancelTicket(ActionEvent event)
    {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("cancelTrain.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Cancel Ticket");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void setLogout(ActionEvent event)
    {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Admin Panel");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void setBookTicket(ActionEvent event)
    {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("bookTrain.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Book Ticket");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
