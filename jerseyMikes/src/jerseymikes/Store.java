package jerseymikes;

import javafx.beans.property.SimpleStringProperty;

public class Store {

    private final SimpleStringProperty storeId;
    private final SimpleStringProperty week1;
    private final SimpleStringProperty week2;
    private final SimpleStringProperty week3;
    private final SimpleStringProperty week4;
    private final SimpleStringProperty week5;

    public Store(String storeId, String week1, String week2, String week3, String week4, String week5) {
        this.storeId = new SimpleStringProperty(storeId);
        this.week1 = new SimpleStringProperty(week1);
        this.week2 = new SimpleStringProperty(week2);
        this.week3 = new SimpleStringProperty(week3);
        this.week4 = new SimpleStringProperty(week4);
        this.week5 = new SimpleStringProperty(week5);

    }

    public String getWeek1() {
        return week1.get();
    }

    public void setWeek1(String week) {
        week1.set(week);
    }
       public String getWeek2() {
        return week2.get();
    }

    public void setWeek2(String week) {
        week2.set(week);
    }
       public String getWeek3() {
        return week3.get();
    }

    public void setWeek3(String week) {
        week3.set(week);
    }
       public String getWeek4() {
        return week4.get();
    }

    public void setWeek4(String week) {
        week4.set(week);
    }
      public String getWeek5() {
        return week5.get();
    }

    public void setWeek5(String week) {
        week5.set(week);
    }
    public String getStoreId() {
        return storeId.get();
    }

    public void setStoreId(String fName) {
        storeId.set(fName);
    }
}
