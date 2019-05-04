package sample;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class confirmbookingController implements Initializable {


    @FXML
    Button btnBack;
    ResultSet rs;
    int av1;
    @FXML
    Button btnBook;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAge;
    @FXML
    TextArea dispID;
    public String trainId;
    public String trainName;

@FXML
    public void setBtnBack(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("bookTrain.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Book Tickets");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    int id2;
@FXML
    public void setBtnBook(ActionEvent event) throws SQLException {

        String name = txtName.getText();
        String age = txtAge.getText();
        int age1=Integer.parseInt(age);
        if(age1<0)
        {
            Stage secondaryStage = new Stage();
            Parent root1 = null;
            try {
                root1 = FXMLLoader.load(getClass().getResource("invalidage.fxml"));
            } catch (IOException f) {
            }
            secondaryStage.setTitle("Error");
            secondaryStage.setScene(new Scene(root1, 316, 66));
            secondaryStage.show();
            txtAge.setText("");
        }
        else {
            Random rand = new Random();
            int id1 = rand.nextInt(1000);
            String bookingID = Integer.toString(id1);
            id2 = id1;
            //String sql2="SELECT from booking1 WHERE trainid ='"+trainId+"'" ;
            // Datasource.executeQuery(sql2);


            bookTrainController bookTrainController = new bookTrainController();
            av1 = bookTrainController.av1;
            int av2 = av1 - 1;

            ResultSet rs;
            String sqlsearch = "SELECT * FROM train1 WHERE trainid='" + trainId + "'";
            rs = Datasource.dbExecute(sqlsearch);
            while (rs.next()) {
                trainName = rs.getString("trainname");
            }

            try {
                String sql = "INSERT INTO booking1 values('" + bookingID + "','" + (trainId) + "','" + trainName + "','" + name + "','" + age + "')";
                Datasource.executeQuery(sql);


                String msg = "Your Booking ID is " + id2 + " and your fare is INR450";
                dispID.setText(msg);
                txtName.setText("");
                txtAge.setText("");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void setId(String id){

        trainId = id;
        System.out.println(trainId);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
