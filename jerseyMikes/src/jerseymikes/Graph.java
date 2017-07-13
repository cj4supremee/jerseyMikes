package jerseymikes;

import javafx.beans.property.SimpleStringProperty;

public class Graph {

    private final SimpleStringProperty x = new SimpleStringProperty("");
    private final SimpleStringProperty y = new SimpleStringProperty("");


    public Graph() {
        this("", "");
    }

    public Graph(String x, String y) {
        setX(x);
        setY(y);
     
    }

    public String getX() {
        return x.get();
    }

    public void setX(String fName) {
        x.set(fName);
    }

    public String getY() {
        return y.get();
    }

    public void setY(String fName) {
        y.set(fName);
    }
}


   