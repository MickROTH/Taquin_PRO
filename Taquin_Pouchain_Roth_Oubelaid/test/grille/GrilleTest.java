/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import partie.Direction;

/**
 *
 * @author Perso
 */
public class GrilleTest {
    
    public GrilleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTaille method, of class Grille.
     */
    @Test
    public void testGetTaille() {
        System.out.println("getTaille");
        Grille instance = null;
        int expResult = 0;
        int result = instance.getTaille();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrille method, of class Grille.
     */
    @Test
    public void testGetGrille() {
        System.out.println("getGrille");
        Grille instance = null;
        Case[][] expResult = null;
        Case[][] result = instance.getGrille();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Grille.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        String chemin = "";
        Grille instance = null;
        instance.setImage(chemin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Grille.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Grille instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Grille.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object autreGrille = null;
        Grille instance = null;
        boolean expResult = false;
        boolean result = instance.equals(autreGrille);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of permuteCaseAdjacent method, of class Grille.
     */
    @Test
    public void testPermuteCaseAdjacent() {
        System.out.println("permuteCaseAdjacent");
        Grille instance = null;
        instance.permuteCaseAdjacent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of permuteCase method, of class Grille.
     */
    @Test
    public void testPermuteCase() {
        System.out.println("permuteCase");
        Case c1 = null;
        Case c2 = null;
        Grille instance = null;
        instance.permuteCase(c1, c2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of melangeGrille method, of class Grille.
     */
    @Test
    public void testMelangeGrille() {
        System.out.println("melangeGrille");
        int nbpermut = 0;
        Grille instance = null;
        instance.melangeGrille(nbpermut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bougeCase method, of class Grille.
     */
    @Test
    public void testBougeCase() {
        System.out.println("bougeCase");
        Direction direction = null;
        Grille instance = null;
        instance.bougeCase(direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of laCaseVide method, of class Grille.
     */
    @Test
    public void testLaCaseVide() {
        System.out.println("laCaseVide");
        Grille instance = null;
        Case expResult = null;
        Case result = instance.laCaseVide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
