/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerseymikes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String foundType = null;

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblMessage;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        conn = mysqlconnect.Db();

    }

    @FXML
    protected void btnLoginAction(ActionEvent event) throws IOException, SQLException {

        String sql = "SELECT uname,password FROM login where uname = 'admin' AND password = 'admin';";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            foundType = rs.getString(1);
        }

        if (txtUserName.getText().equals(foundType) && txtPassword.getText().equals(foundType)) {
            Parent parent = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
        } else {
            lblMessage.setText("Invalid Credentials");
        }
    }

}
