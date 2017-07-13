package jerseymikes;

import javafx.beans.property.SimpleStringProperty;

public class Person {


    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty position;
    private final SimpleStringProperty salary;
    private final SimpleStringProperty storeId;


   public Person(String firstName, String lastName, String position, String salary, String storeId) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.position = new SimpleStringProperty(position);
        this.salary = new SimpleStringProperty(salary);
        this.storeId = new SimpleStringProperty(storeId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lName) {
        lastName.set(lName);
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String pos) {
        position.set(pos);
    }

    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String sal) {
        salary.set(sal);
    }

    public String getStoreId() {
        return storeId.get();
    }

    public void setStoreiD(String sid) {
        storeId.set(sid);
    }
    
    
}
