package jerseymikes;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author CJ
 */
public class MainController implements Initializable {
//various needed fields

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    PreparedStatement updateEmployee = null;
    String found = null;
    ObservableList<Person> data = FXCollections.observableArrayList();
    ObservableList<Store> dataSales = FXCollections.observableArrayList();
     ObservableList<nStore> dataStores = FXCollections.observableArrayList();
    

//elements under the employee tab
    @FXML
    private TableView<Person> tableID;
    @FXML
    private TextField inputFname;
    @FXML
    private TextField inputLname;
    @FXML
    private TextField inputPosition;
    @FXML
    private TextField inputSalary;
    @FXML
    private TextField inputStoreID;

//elements under the sales tab
    @FXML
    private TableView<Store> salesTable;
    @FXML
    private TextField inputStoreId;
    @FXML
    private TextField inputMonth;
    @FXML
    private TextField inputTotal;
//elements under the store tab
     @FXML
    private TableView<nStore> tableS;
    @FXML
    private TextField inputStore;
    @FXML
    private TextField inputSName;

   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = mysqlconnect.Db();

    }

//function to load employee graph to current state
    @FXML
    protected void loadGraph(ActionEvent event) throws SQLException {

        try {
            String query = "select * from employee";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {

                data.add(new Person(rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("Salary"),
                        rs.getString("Position"),
                        rs.getString("Store_ID")
                ));
                tableID.setItems(data);
            }
        } catch (Exception e2) {
            System.err.println(e2);

        }

    }

//add function for employee table    
    @FXML
    protected void addEmployee(ActionEvent event) throws SQLException {
// the mysql insert statement
        String query = " insert into employee (fname, lname, position, salary, store_id)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, inputFname.getText());
        preparedStmt.setString(2, inputLname.getText());
        preparedStmt.setString(3, inputPosition.getText());
        preparedStmt.setString(4, inputSalary.getText());
        preparedStmt.setString(5, inputStoreID.getText());
        preparedStmt.execute();

    }
// function that clears the text fields of employee entries
    @FXML
    protected void clearFields(ActionEvent event) {
        inputFname.clear();
        inputLname.clear();
        inputPosition.clear();
        inputSalary.clear();
        inputStoreID.clear();

    }
//delete function for employee table

    @FXML
    protected void deleteEmployee(ActionEvent event) {
        ObservableList<Person> productSelected, allProducts;
        allProducts = tableID.getItems();
        productSelected = tableID.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);

    }

//add function for store table within sales tab  
    @FXML
    protected void loadSales(ActionEvent event) {

 try {
            String query = "select * from sales";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {

                dataSales.add(new Store(rs.getString("Store_ID"),
                        rs.getString("Week1"),
                        rs.getString("Week2"),
                        rs.getString("Week3"),
                        rs.getString("Week4"),
                        rs.getString("Week5")
                ));
                salesTable.setItems(dataSales);
            }
        } catch (Exception e2) {
            System.err.println(e2);

        }
    }

//delete function for store table    
    @FXML
    protected void deleteStore(ActionEvent event) {
        ObservableList<nStore> productSelected, allProducts;
        allProducts = tableS.getItems();
        productSelected = tableS.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);

    }
// function to load store graph     
    @FXML
    protected void loadStores (ActionEvent event){
         try {
            String query = "select * from store";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {

                dataStores.add(new nStore(rs.getString("Store_ID"),
                        rs.getString("StoreName")
                        
                        
                ));
                
                tableS.setItems(dataStores);
            }
        } catch (Exception e2) {
            System.err.println(e2);

        }
    }
//function to clear store fields    
      @FXML
    protected void clearStore(ActionEvent event) {
        inputStore.clear();
        inputSName.clear();

  
    }
// function to add store
       @FXML
    protected void addStore(ActionEvent event) throws SQLException {
// the mysql insert statement
        String query = " insert into store (store_id, StoreName )"
                + " values (?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, inputStore.getText());
        preparedStmt.setString(2, inputSName.getText());

 
        preparedStmt.execute();

    }
    }


