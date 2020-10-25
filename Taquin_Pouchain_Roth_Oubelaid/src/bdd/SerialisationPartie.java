/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import partie.Partie;

/**
 *
 * @author Perso
 */
public class SerialisationPartie {

    public void serialise(Partie laPartie) {
        //finalPartie partie = new Partie("Dupond", "Jean", 175);
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("partie.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(laPartie);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deserialise() {
        Partie unePartie;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            final FileInputStream fichierIn = new FileInputStream("personne.ser");
            ois = new ObjectInputStream(fichierIn);
            unePartie = (Partie) ois.readObject();
            System.out.println("Personne : ");
            System.out.println("nom : " + unePartie.getType());
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
