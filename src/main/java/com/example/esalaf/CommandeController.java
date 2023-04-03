package com.example.esalaf;

import com.example.model.Client;
import com.example.model.ClientDAO;
import com.example.model.Commande;
import com.example.model.CommandeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    @FXML
    private Button save;
    @FXML
    private TextField Produit;
    @FXML
    private TextField prix;
    @FXML
    private TextField date;
    @FXML
    private TableView<Commande> Tab;

    @FXML
    private TableColumn<Commande, String> produit;


    @FXML
    private TableColumn<Commande, String> ID_client;





    @FXML
    protected void onSaveButton(){
        Commande cmd = new Commande( Produit.getText(), prix.getText());

        try {
            CommandeDAO cmdao = new CommandeDAO();
            cmdao.save(cmd);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }
    public void UpdateTable(){
        produit.setCellValueFactory(new PropertyValueFactory<Commande,String>("Produit"));

        ID_client.setCellValueFactory(new PropertyValueFactory<Commande,String>("prix"));


        Tab.setItems(getDataCommandes());
    }


    public static ObservableList<Commande> getDataCommandes(){

        CommandeDAO cmdao = null;

        ObservableList<Commande> listf = FXCollections.observableArrayList();

        try {
            cmdao = new CommandeDAO();
            for(Commande ettemp : cmdao.getAll())
                listf.add(ettemp);

        } catch (SQLException C) {
            throw new RuntimeException(C);
        }

        return listf ;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
