package com.example.model;

import java.util.Date;

public class Commande {
    protected String produit;
    protected String prix;




    public Commande() {
    }


    public Commande(String prix, String produit){

        this.produit = produit;
        this.prix = prix;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {

        this.produit = produit;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande='" + produit + '\'' +
                ", id_client='" + prix + '\'' +

                '}';
    }
}
