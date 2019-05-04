package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class searchTrainController implements Initializable{
    @FXML
    TableView TrainSearch;
    @FXML TableColumn<Train,String> trainname;
    @FXML TableColumn<Train,Integer> trainid;
    @FXML TableColumn<Train,String> dptime;
    @FXML TableColumn<Train,String> artime;
    @FXML TableColumn<Train,Integer> Av;
    @FXML
    Button close;
    @FXML
    Button btnBook;
    @FXML
    Button btnSearch;
    @FXML
    TextField txtStartPoint;
    @FXML
    TextField txtDestination;
    @FXML
    Button btnClear;

    @FXML
    void setBtnClear()
    {
        txtStartPoint.setText("");
        txtDestination.setText("");
    }


    public void setClose(ActionEvent event)
    {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("adminpanel.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Admin Panel");
            window.setScene(new Scene(root1, 600, 400));
            window.show();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    int source=0,destination=0;
    int[][] st={
            {0,2,0,3,4,5,0,6,0,0,0,7,8,9,0},
            {1,0,10,0,0,0,11,0,12,0,0,0,0,0,0},
            {0,20,0,27,0,0,24,0,0,0,0,23,0,0,0},
            {13,0,28,0,0,0,29,0,0,0,0,30,0,0,0},
            {14,0,0,0,0,33,0,0,0,35,0,0,0,0,0},
            {15,0,0,0,34,0,0,0,0,0,37,0,0,0,38},
            {0,21,25,31,0,0,0,0,0,0,0,41,0,0,0},
            {16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,22,0,0,0,0,0,0,0,0,0,0,42,0,0,0},
            {0,0,0,0,36,0,0,0,0,0,0,0,0,0,0,},
            {0,0,0,0,0,39,0,0,0,0,0,0,0,0,44},
            {10,0,26,32,0,0,42,0,43,0,0,0,0,0,0},
            {18,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {19,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,40,0,0,0,0,45,0,0,0,0}};
    @FXML
    public void setBtnSearch()

    {
        String s = txtStartPoint.getText();
        ResultSet rs=null;
        String d = txtDestination.getText();
        source=setDS(s);
        destination=setDS(d);
       if(source==-1||destination==-1)
       {
           Stage secondaryStage = new Stage();
           Parent root1 = null;
           try {
               root1 = FXMLLoader.load(getClass().getResource("invalidtrain.fxml"));
           } catch (IOException f) {
           }
           secondaryStage.setTitle("ErrorInvalidTrain");
           secondaryStage.setScene(new Scene(root1, 316, 66));
           secondaryStage.show();
       }
       else if(st[source][destination]==0)
       {
           Stage secondaryStage = new Stage();
           Parent root1 = null;
           try {
               root1 = FXMLLoader.load(getClass().getResource("trainnotfound.fxml"));
           } catch (IOException f) {
           }
           secondaryStage.setTitle("ErrorTrainNotFound");
           secondaryStage.setScene(new Scene(root1, 316, 66));
           secondaryStage.show();

       }
       else
       {

           int trainID=st[source][destination];
           if(trainID!=0) {
               String sqlsearch = "SELECT * FROM train1 WHERE trainid='" + trainID + "'";
               rs = Datasource.dbExecute(sqlsearch);
               populateTable(rs);
           }
       }

    }

    int setDS(String s4)
    {
        String s=s4.toLowerCase();
        int s1;
        if(s.equals("Mumbai")||s.equals("mumbai"))
        {
             s1=1;
        }
        else if(s.equals("Nashik")||s.equals("nashik"))
        {
            s1=2;
        }
        else if(s.equals("Hyderabad")||s.equals("hyderabad"))
        {
            s1=3;
        }
        else if(s.equals("Chennai")||s.equals("chennai"))
        {
            s1=4;
        }
        else if(s.equals("Delhi")||s.equals("delhi"))
        {
            s1=5;
        }
        else if(s.equals("Kolkata")||s.equals("kolkata"))
        {
            s1=6;
        }
        else if(s.equals("Pune")||s.equals("pune"))
        {
            s1=7;
        }
        else if(s.equals("Goa")||s.equals("goa"))
        {
            s1=8;
        }
        else if(s.equals("Indore")||s.equals("indore"))
        {
            s1=9;
        }
        else if(s.equals("Amritsar")||s.equals("amritsar"))
        {
            s1=10;
        }
        else if(s.equals("Ranchi")||s.equals("ranchi"))
        {
            s1=11;
        }
        else if(s.equals("Bangalore")||s.equals("bangalore"))
        {
            s1=12;
        }
        else if(s.equals("Ahmedabad")||s.equals("ahmedabad"))
        {
            s1=13;
        }
        else if(s.equals("Jaipur")||s.equals("jaipur"))
        {
            s1=14;
        }
        else if(s.equals("Patna")||s.equals("patna"))
        {
            s1=15;
        }
        else {
            s1=0;
        }

        return (s1-1);
        }

    @FXML
 void setBtnBook(ActionEvent event)
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

    public void populateTable(ResultSet rs) {
        try {
            ObservableList<Train> trains = FXCollections.observableArrayList();

            while (rs.next()) {

                Train b = new Train();

                b.setTrId(rs.getInt("trainid"));
                b.setTrName(rs.getString("trainname"));
                b.setArTime(rs.getString("arrivaltime"));
                b.setDpTime(rs.getString("departuretime"));
                b.setAv(rs.getInt("availability"));
                trains.add(b);
                TrainSearch.setItems(trains);
            }

        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainid.setCellValueFactory(cellData -> cellData.getValue().trIdProperty().asObject());
        trainname.setCellValueFactory(cellData -> cellData.getValue().trNameProperty());
        artime.setCellValueFactory(cellData -> cellData.getValue().arTimeProperty());
        dptime.setCellValueFactory(cellData -> cellData.getValue().dpTimeProperty());
        Av.setCellValueFactory(cellData -> cellData.getValue().AvProperty().asObject());
    }
}
