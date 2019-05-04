package sample;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Passenger {
    public IntegerProperty trID;
    public StringProperty bookID;
    public StringProperty trainName;
    public  StringProperty age;
    public StringProperty name;

    Passenger(){
        this.trID=new SimpleIntegerProperty();
        this.trainName=new SimpleStringProperty();
        this.bookID=new SimpleStringProperty();
        this.age=new SimpleStringProperty();
        this.name=new SimpleStringProperty();
    }
    public int getTrId()
    {
        return  trID.get();
    }
    public IntegerProperty trIDProperty(){return trID;}
    public void setTrId(int trId){this.trID.set(trId);}

    public String getTrainName(){return trainName.get();}
    public StringProperty trainNameProperty(){return trainName;}
    public void setTrainName(String trainName){this.trainName.set(trainName);}

    public String getBookID(){return bookID.get();}
    public StringProperty bookIDroperty(){return bookID;}
    public void setBookID(String bookID){this.bookID.set(bookID);}

    public String getAge(){return age.get();}
    public StringProperty ageProperty(){return age;}
    public void setAge(String age){this.age.set(age);}

    public String getname(){return name.get();}
    public StringProperty nameProperty(){return name;}
    public void setname(String name){this.name.set(name);}

}
