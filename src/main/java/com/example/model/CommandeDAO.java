package com.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CommandeDAO extends BaseDAO<Commande>{

    public CommandeDAO() throws SQLException {

        super();

    }


    @Override
    public void save(Commande object) throws SQLException {

        String rq = "insert into commande (produit, prix) values (?, ?);";

        this.preparedStatement = this.connection.prepareStatement(rq);

        this.preparedStatement.setString(1 , object.getProduit());
        this.preparedStatement.setString(2 , object.getPrix());

        this.preparedStatement.execute();
    }


    @Override
    public void update(Commande object) throws SQLException {

    }

    @Override
    public void delete(Commande object) throws SQLException {

    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Commande> getAll() throws SQLException {
        List<Commande> mylist = new ArrayList<>();
        String rq = " select * from commande" ;


        this.statement = this.connection.createStatement();

        this.resultSet =  this.statement.executeQuery(rq);

        while (this.resultSet.next()){

            mylist.add( new Commande(this.resultSet.getString(1),
                    this.resultSet.getString(2)));


        }

        return mylist;
    }
}


