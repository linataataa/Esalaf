package com.example.model;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {


        try {
            // entity
            Client C = new Client(1, "lina", "0606060660");



            //Transacatio
            ClientDAO clidao = new ClientDAO();




            // save trasanction
            clidao.save(C);




            List<Client> mylist = clidao.getAll();




            for (Client temp : mylist) {

                System.out.println(temp.toString());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



