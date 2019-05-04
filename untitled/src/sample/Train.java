package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Train {
    public IntegerProperty trId;
    public StringProperty trName;
    public StringProperty dpTime;
    public StringProperty arTime;
    public IntegerProperty Av;

    Train()
    {
        this.trId=new SimpleIntegerProperty();
        this.trName=new SimpleStringProperty();
        this.dpTime=new SimpleStringProperty();
        this.arTime=new SimpleStringProperty();
        this.Av=new SimpleIntegerProperty();
    }
    public int getTrId()
    {
        return  trId.get();
    }
    public IntegerProperty trIdProperty(){return trId;}
    public void setTrId(int trId){this.trId.set(trId);}

    public String getTrName(){return trName.get();}
    public StringProperty trNameProperty(){return trName;}
    public void setTrName(String trName){this.trName.set(trName);}

    public String getdpTime(){return dpTime.get();}
    public StringProperty dpTimeProperty(){return dpTime;}
    public void setDpTime(String dpTime){this.dpTime.set(dpTime);}

    public String getArTime(){return arTime.get();}
    public StringProperty arTimeProperty(){return arTime;}
    public void setArTime(String arTime){this.arTime.set(arTime);}

    public int getAv(){return  Av.get();}
    public IntegerProperty AvProperty(){return Av;}

    public void setAv(int av) {
        this.Av.set(av);
    }
}
