/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Perso
 */
public class Chrono {

    /**
     * Attributs de la classe chrono
     */
    private long tempsDepart = 0;
    private long tempsFin = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private long duree = 0;

    /**
     * Permet de lancer le chrono
     */
    public void start() {
        tempsDepart = System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    /**
     * Mettre en pause le chrono
     */
    public void pause() {
        if (tempsDepart == 0) {
            return;
        }
        pauseDepart = System.currentTimeMillis();
    }

    /**
     *
     */
    public void resume() {
        if (tempsDepart == 0) {
            return;
        }
        if (pauseDepart == 0) {
            return;
        }
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    /**
     * permet d'arreter le chrono
     */
    public void stop() {
        if (tempsDepart == 0) {
            return;
        }
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
    }

    /**
     * Recupération de la durée en seconde
     *
     * @return la durée sous forme d'un long represente les secondes 
     */
    public long getDureeSec() {
        return duree / 1000;
    }

    /**
     * Récupération de la durée en milliseconde
     *
     * @return la durée sous forme d'un long represente les milisecondes 
     */
    public long getDureeMs() {
        return duree;
    }

    /**
     * Récupération de la durée en texte
     *
     * @return retourne le temps en texte 
     */
    public String getDureeTxt() {
        return timeToHMS(getDureeSec());
    }

    /**
     * conversion de l'heure en texte
     *
     * @param tempsS le temps en long passer en parametre à convertir 
     * @return la chaine de caractere du temps écouler 
     */
    public static String timeToHMS(long tempsS) {

        // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "1 h 26 min 3 s"
        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r = "";

        if (h > 0) {
            r += h + " h ";
        }
        if (m > 0) {
            r += m + " min ";
        }
        if (s > 0) {
            r += s + " s";
        }
        if (h <= 0 && m <= 0 && s <= 0) {
            r = "0 s";
        }

        return r;
    }

} // class Chrono
