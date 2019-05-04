package sample;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class cancelTrainController implements Initializable{
    ResultSet rs;
    @FXML
    javafx.scene.control.Button backCancelTicket;
    @FXML
    javafx.scene.control.Button btnCancel;
    @FXML
    TextField txtId;
    @FXML
    TextArea dispStatus;
    @FXML
    TableView CancelDisplay;
    @FXML
        TableColumn<Passenger, String> bookid;
    @FXML
    TableColumn<Passenger, Integer> trainid;
    @FXML
    TableColumn<Passenger, String> trainname;

    @FXML
    TableColumn<Passenger, String> name;
    @FXML
    TableColumn<Passenger, String> age;

    String trainno;
    int resultcheck=0;
    @FXML
    public void setBackCancelTicket(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("adminpanel.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Cancel Ticket");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    int r = 0;
    String Id;

    public void setBtnCancel(ActionEvent event) throws SQLException {
        Id = txtId.getText();
        if(Id.equals(""))
        {
            Stage secondaryStage = new Stage();
            Parent root1 = null;
            try {
                root1 = FXMLLoader.load(getClass().getResource("invalidid.fxml"));
            } catch (IOException f) {
            }
            secondaryStage.setTitle("Error");
            secondaryStage.setScene(new Scene(root1, 316, 66));
            secondaryStage.show();
        }
        else {
            try {
                String sqlquery1 = "SELECT * FROM booking1 WHERE bookingid='" + Id + "'";
                rs = Datasource.dbExecute(sqlquery1);
                populateTable(rs);

            } catch (Exception exception) {

            }
        }


    }
    public void displayerror() {
        dispStatus.setText("No Booking Found for this ID");
    }

    public void displaysuccess() {
        dispStatus.setText("Booking Deleted Successfully Return INR313.85");
    }

    public void populateTable(ResultSet rs) {
        try {
            ObservableList<Passenger> passenger = FXCollections.observableArrayList();

            while (rs.next()) {

                Passenger b = new Passenger();
                b.setBookID(rs.getString("bookingid"));
                b.setTrId(rs.getInt("trainid"));
                b.setTrainName(rs.getString("trainname"));
                b.setname(rs.getString("name"));
                b.setAge(rs.getString("age"));
                passenger.add(b);
                CancelDisplay.setItems(passenger);
                trainno= rs.getString("bookingid");
                if(trainno.equals(Id))
                {
                    resultcheck=1;
                }

            }

        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }
    @FXML
    public void setBtnConfirm(ActionEvent event)throws SQLException
    {


            if (resultcheck == 1) {
                String sqlquery1 = "DELETE FROM booking1 WHERE bookingid='" + Id + "'";
                Datasource.executeQuery(sqlquery1);
                txtId.setText("");
                displaysuccess();
                while (rs.next()) {
                    {
                        int av1 = rs.getInt("availablility");
                        int av2 = av1 + 1;


                    }
                }


            } else {
                displayerror();
            }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookid.setCellValueFactory(cellData -> cellData.getValue().bookIDroperty());
        trainid.setCellValueFactory(cellData -> cellData.getValue().trIDProperty().asObject());
        trainname.setCellValueFactory(cellData -> cellData.getValue().trainNameProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        age.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
    }
}
