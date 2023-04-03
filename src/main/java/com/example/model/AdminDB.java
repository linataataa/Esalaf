package com.example.model;

import java.sql.*;

public class AdminDB extends Admin {
    protected String url = "jdbc:mysql://127.0.0.1:3306/esalaf" ;

    protected String login = "root";

    protected String password = "";

    protected Connection con;
    protected Statement statement ;
    protected PreparedStatement preparedStatement ;
    protected ResultSet resultSet ;


    public AdminDB() {
        try {

        this.con = DriverManager.getConnection(url , login , password);

        }catch (SQLException AA){
            AA.printStackTrace();
        }
    }
    public int checkLogin(String email, String password){
        if(this.con == null)
            return -1;
        String sql = "SELECT * FROM `admin` WHERE email=? AND password=?  ";


        try{
            this.preparedStatement = this.con.prepareStatement(sql);
            this.preparedStatement.setString(1 , email);
            this.preparedStatement.setString(2 , password);
            this.resultSet = this.preparedStatement.executeQuery();

          /*  this.statement = this.con.createStatement();
            this.resultSet = this.statement.executeQuery(sql);*/
            if (!this.resultSet.next()) {
                return -1; // Les informations de connexion sont incorrectes
            }
            return 0; // Les informations de connexion sont correctes



        }catch (SQLException Li){
            Li.printStackTrace();
        }
        return -1; // Une erreur s'est produite lors de la connexion




    }


}
