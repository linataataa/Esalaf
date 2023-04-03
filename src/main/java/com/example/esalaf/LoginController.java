package com.example.esalaf;

import com.example.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

//hada hellocontroller pour ne pas oublier
public class LoginController implements Initializable {
    @FXML
    private Button logout;
    @FXML
    private Button Delete;
    @FXML
    private Button Update;
    @FXML
    private TextField nom;

    @FXML
    private TextField tele;


    @FXML
    private TableView<Client> mytab;

    @FXML
    private TableColumn<Client, Long> col_id;

    @FXML
    private TableColumn<Client, String> col_nom;

    @FXML
    private TableColumn<Client, String> col_tele;


    @FXML
    protected void onSaveButtonClick(){
        Client cli = new Client(0l , nom.getText() , tele.getText());

        try {
            ClientDAO clidao = new ClientDAO();
            clidao.save(cli);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }
    public void onLogout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("logged-in.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
    public void onEnregistre(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("commade.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void onDelete() {
        int selectedIndex = mytab.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Client client = mytab.getItems().get(selectedIndex);
            try {
                ClientDAO Clida = new ClientDAO();
                Clida.delete(client);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            mytab.getItems().remove(selectedIndex);
        }
        UpdateTable();
    }
    public void onUpdate() {
        Client client = mytab.getSelectionModel().getSelectedItem();

        if (client == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucun client sélectionné");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un client à mettre à jour.");
            alert.showAndWait();
            return;
        }

        client.setNom(nom.getText());
        client.setTelepehone(tele.getText());

        try {
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.update(client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }


        public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Client,Long>("id_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));

        col_tele.setCellValueFactory(new PropertyValueFactory<Client,String>("telepehone"));


        mytab.setItems(getDataClients());
    }

    public static ObservableList<Client> getDataClients(){

        ClientDAO clidao = null;

        ObservableList<Client> listfx = FXCollections.observableArrayList();

        try {
            clidao = new ClientDAO();
            for(Client ettemp : clidao.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {

        UpdateTable();

         }




}
