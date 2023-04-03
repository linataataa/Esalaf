package com.example.esalaf;

import com.example.model.Admin;
import com.example.model.AdminDB;
import com.example.model.BaseDAO;
import com.example.model.Client;
import com.example.model.ClientDAO;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class loggedController implements Initializable {
    @FXML
    private Button login;
    @FXML
    private Button signup;

    @FXML
    private TextField mail;
    @FXML
    private TextField pswd;

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        String email = mail.getText();
        String password = pswd.getText();

        AdminDB adminDB = new AdminDB();
        int result = adminDB.checkLogin(email, password);
        if(result == 0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        else{
            System.out.println("utilisateur introuvable");
        }

    }
    public void onSignUp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sing-up.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        }
}
