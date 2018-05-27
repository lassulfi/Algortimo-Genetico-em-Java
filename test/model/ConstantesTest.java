/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisDaniel
 */
public class ConstantesTest {
    
    public ConstantesTest() {
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
     * Test of function1 method, of class Constantes.
     */
    @Test
    public void testFunction1() {
        System.out.println("function1");
        double x = 0.0;
        double expResult = 0.0;
        double result = Constantes.function1(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizeCromossomo method, of class Constantes.
     */
    @Test
    public void testGetSizeCromossomo() {
        System.out.println("getSizeCromossomo");
        int expResult = 9;
        int result = Constantes.getSizeCromossomo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizePopulacao method, of class Constantes.
     */
    @Test
    public void testGetSizePopulacao() {
        System.out.println("getSizePopulacao");
        int expResult = 100;
        int result = Constantes.getSizePopulacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
