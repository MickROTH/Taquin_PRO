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

/**
 *
 * @author Perso
 */
public class CaseTest {
    
    public CaseTest() {
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
     * Test of getValue method, of class Case.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Case instance = new Case();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Case.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int uneVal = 0;
        Case instance = new Case();
        instance.setValue(uneVal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of permuteCoo method, of class Case.
     */
    @Test
    public void testPermuteCoo() {
        System.out.println("permuteCoo");
        Case autreCase = null;
        Case instance = new Case();
        instance.permuteCoo(autreCase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Case.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Case instance = new Case();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
