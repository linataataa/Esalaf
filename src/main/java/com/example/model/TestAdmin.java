package com.example.model;

import java.sql.SQLException;
import java.util.List;

public class TestAdmin {
    public static void main(String[] args) {
        // entity
        Admin A  = new Admin("linataacha@gmail.com","linataacha");


        //Transacatio
        AdminDB Adao = new AdminDB();


        // save trasanction
        Adao.checkLogin("linataacha@gmail.com","linataacha");


    }
    }

