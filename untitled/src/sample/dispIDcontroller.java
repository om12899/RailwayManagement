package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class dispIDcontroller  {
    @FXML
    Text dispID;
    int Id;

    public void setDispID()
    {
        String msg="your booking id is"+Id+" ";
        dispID.setText(msg);
    }
    public void setId(int id2)
    {
        Id=id2;
    }
}
