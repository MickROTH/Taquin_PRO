/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Perso
 */
public class ConnexionBDD {

    /**
     * Attributs de la classe
     */
    private String host, port, dbname, username, password;
    private Connection con = null;

    /**
     * Constructeur de la classe ConnexionBDD
     *
     * @param h correspond à l'host 
     * @param po correspont au port 
     * @param dbn le nom de la base de donnée
     * @param u le nom d'utilisateur pour ce connecter à la base 
     * @param p mot de passe de la base de donnée 
     */
    public ConnexionBDD(String h, String po, String dbn, String u, String p) {
        this.host = h;
        this.port = po;
        this.dbname = dbn;
        this.username = u;
        this.password = p;
    }

    /*
     * Ouvre la connexion avec la base de données
     */
    private void openConnexion() {
        String connectUrl = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbname + "?autoReconnect=true&useSSL=false";
        if (con != null) {
            this.closeConnexion();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //System.out.println("Driver ok.");
            con = DriverManager.getConnection(connectUrl, username, password);
            //System.out.println("Database connection established.");
        } catch (ClassNotFoundException cnfe) {
            throw new IllegalArgumentException("Cannot load db driver: com.mysql.jdbc.Driver");

        } catch (Exception e) {
            throw new IllegalArgumentException("Erreur inattendue");

        }
    }

    /*
     * Ferme la connexion avec la base de données
     */
    private void closeConnexion() {
        if (con != null) {
            try {
                con.close();
                //System.out.println("Database connection terminated.");
            } catch (Exception e) {
                /* ignore close errors */ }
        }
    }

    /*
     * Interroge la base de données avec la requête passée en paramètre
     * et retourne les résultats sous forme d'une liste de String.
     * Il faut utiliser la méthode executeQuery dans la classe Statement (voir cours 12).
     * Indice : comme on ne sait pas à l'avance combien d'attributs (colonnes) on a dans nos tuples,
     * on peut utiliser la classe ResultSetMetaData (voir méthodes getMetaData() de la classe ResultSet et getColumnCount() de la classe ResultSetMetaData)
     */
    public ArrayList<String> getTuples(String query) {
        ArrayList<String> res = null;
        try {
            this.openConnexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData(); // permet de récupérer les noms des colonnes des tuples en sortie de la requête
            String tuple;
            res = new ArrayList<>();
            while (rs.next()) {
                tuple = "";
                for (int i = 1; i <= metadata.getColumnCount(); i++) {
                    tuple += rs.getString(i);
                    if (i < metadata.getColumnCount()) {
                        tuple += ";";
                    }
                }
                res.add(tuple);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Probleme avec la requete");
        } finally {
            this.closeConnexion();
        }
        return res;
    }

    /*
     * Insère un ou plusieurs tuples dans la base à partir de la requête passée en paramètre
     * Pour cela, il faut utiliser la méthode executeUpdate dans la classe Statement
     */
    public void insertTuples(String updateQuery) {
        try {
            this.openConnexion();
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(updateQuery);
            //System.out.println(n+" tuples inseres");
            stmt.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Probleme avec la requete d'insertion");
            //System.out.println("Tuple deja existant");
        } finally {
            this.closeConnexion();
        }
    }

    /*
     * Modifier un tuple dans la base à partir de la requête passée en paramètre
     * Pour cela, il faut utiliser la méthode executeUpdate dans la classe Statement
     */
    public void updateTuples(String updateQuery) {
        try {
            this.openConnexion();
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(updateQuery);
            //System.out.println(n+" tuples inseres");
            stmt.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Probleme avec la requete de modification");
        } finally {
            this.closeConnexion();
        }
    }

}
