package partie;

/**
 * Représente les différents type de partie possibles
 *
 * @author micka
 */
public enum TypePartie {
    SOLO, // Un seul joueur résoud une grille
    COOP, // Deux joueurs résolvent la même grille ensemble (coopération)
    VERSUS // Deux joueurs s'affrontent : chacun doit résoudre une grille de son côté, commençant avec la même configuration initiale
}
