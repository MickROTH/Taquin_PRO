package partie;

import grille.Grille;
import joueur.Joueur;

/**
 * Représente une partie de taquin jouée par un ou deux joueurs.
 * @see Joueur
 * @see Grille
 * @author Mick
 */
public class Partie {
    /**
     * @attribute Type de partie parmis SOLO, COOP, VERSUS
     */
    private String type;
    
    /**
     * @attribute Grille de taquin sur laquelle se déroule la partie.
     */
    private Grille grille;
    
    /**
     * @attribute Liste des joueurs de cette partie.<br>
     * Il peut y avoir un ou deux joueurs dans une partie.
     */
    private Joueur[] joueurs;

    /**
     * Constructeur privé : Crée une partie de taquin mais sans préciser le(s) joueur(s).
     * @param type Type de partie (SOLO, COOP ou VERSUS)
     * @param grille La grille de taquin
     * @throws IllegalArgumentException Si le type ne fait pas partie des types connus.
     */
    private Partie(String type, Grille grille){
        if(!Type.estConnu(type)){
            throw new IllegalArgumentException("Ce type de partie n'est pas connu : " + type);
        }
        this.grille = grille;
        this.type = type;
    }
    
    /**
     * Constructeur : Crée une partie de taquin avec un ou 2 joueurs.
     * @param type Type de partie (SOLO, COOP ou VERSUS)
     * @param grille La grille de taquin
     * @param joueurs Le ou les joueur(s) de cette partie
     * @throws IllegalArgumentException Si le type ne fait pas partie des types connus ou s'il n'y a pas exactement 1 ou 2 joueur(s) ou si le nombre de joueurs ne correspond pas au type de partie (ex : 2 joueurs pour une partie SOLO).
     */
    public Partie(String type, Grille grille, Joueur[] joueurs){
        this(type, grille);
        this.setJoueurs(joueurs);
    }
    
    /**
     * Constructeur : Crée une partie de taquin avec deux joueurs.
     * @param type Type de partie (SOLO, COOP ou VERSUS)
     * @param grille La grille de taquin
     * @param j1 Joueur 1
     * @param j2 Joueur 2
     * @throws IllegalArgumentException Si le type ne fait pas partie des types connus ou s'il n'y a pas exactement 1 ou 2 joueur(s) ou si le nombre de joueurs ne correspond pas au type de partie (ex : 2 joueurs pour une partie SOLO).
     */
    public Partie(String type, Grille grille, Joueur j1, Joueur j2){
        this(type, grille);
        joueurs = new Joueur[2];
        joueurs[0] = j1;
        joueurs[1] = j2;
        this.setJoueurs(joueurs);
    }

    /**
     * Constructeur : Crée une partie de taquin avec un seul joueur.
     * @param type Type de partie (SOLO, COOP ou VERSUS)
     * @param grille La grille de taquin
     * @param j1 Joueur 1
     * @param j2 Joueur 2
     * @throws IllegalArgumentException Si le type ne fait pas partie des types connus ou s'il n'y a pas exactement 1 ou 2 joueur(s) ou si le nombre de joueurs ne correspond pas au type de partie (ex : 2 joueurs pour une partie SOLO).
     */
    public Partie(String type, Grille grille, Joueur j1){
        this(type, grille);
        joueurs = new Joueur[1];
        joueurs[0] = j1;
        this.setJoueurs(joueurs);
    }
        
    /**
     * @return Le type de la partie (ex : "SOLO", "COOP" ou "VERSUS")
     */
    public String getType(){
        return this.type;
    }

    /**
     * @return La grille de taquin sur laquelle se déroule la partie
     */
    public Grille getGrille(){
        return this.grille;
    }
        
    /**
     * @return Une copie de la liste des joueurs de la partie
     */
    public Joueur[] getJoueurs(){
        return this.joueurs.clone();
    }
    
    /**
     * Méthode privée instanciant la liste des joueurs de la partie après vérification de sa cohérence.
     * @param joueurs Liste de joueurs
     * @throws IllegalArgumentException S'il n'y a pas exactement 1 ou 2 joueur(s) ou si le nombre de joueurs ne correspond pas au type de partie (ex : 2 joueurs pour une partie SOLO).
     */
    private void setJoueurs(Joueur[] joueurs){
        if(joueurs.length == 0 || joueurs.length > 2){
            throw new IllegalArgumentException("Nombre de joueurs compris entre 1 et 2 inclus uniquement.");
        }
        if(joueurs.length == 1 && !this.type.equals(Type.SOLO)){
            throw new IllegalArgumentException("Une partie SOLO se joue obligatoirement seul.");
        }
        if(joueurs.length == 2 && this.type.equals(Type.SOLO)){
            throw new IllegalArgumentException("Une partie COOP ou VERSUS se joue obligatoirement à 2.");
        }
        this.joueurs = joueurs;
    }
    
    
    
    /**
     * Classe interne accessible à tous qui rescence les différents types de partie connus et fourni des fonctions y afférent.
     */
    public static class Type{
        /**
         * Type de partie : solo.
         */
        public static final String SOLO = "SOLO";
        /**
         * Type de partie : coopération avec un 2ème joueur.
         */
        public static final String COOP = "COOP";
        /**
         * Type de partie : confrontation avec un 2ème joueur.
         */
        public static final String VERSUS = "VERSUS";
        
        /**
         * Teste si un type donné correspond aux types de partie connus
         * @param type Type de partie à tester
         * @return True si le type donné correspond à un type connu
         */
        public static boolean estConnu(String type){
            return (type.equals(SOLO) || type.equals(COOP) || type.equals(VERSUS));
        }
    }
}
