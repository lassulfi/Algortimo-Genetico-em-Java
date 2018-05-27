/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.BitSet;
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
public class IndividuoTest {
    
    public IndividuoTest() {
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
     * Test of getCromossomo method, of class Individuo.
     */
    @Test
    public void testGetCromossomo() {
        System.out.println("getCromossomo");
        Individuo instance = new Individuo();
        BitSet expResult = instance.getCromossomo();
        BitSet result = instance.getCromossomo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("O teste do método getCromossomo falhou");
    }

    /**
     * Test of getFitness method, of class Individuo.
     */
    @Test
    public void testGetFitness() {
        System.out.println("getFitness");
        Individuo instance = new Individuo();
        double expResult = 0.0;
        double result = instance.getFitness();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFitness method, of class Individuo.
     */
    @Test
    public void testSetFitness() {
        System.out.println("setFitness");
        double fitness = 0.0;
        Individuo instance = new Individuo();
        instance.setFitness(fitness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFitnessPercentual method, of class Individuo.
     */
    @Test
    public void testGetFitnessPercentual() {
        System.out.println("getFitnessPercentual");
        Individuo instance = new Individuo();
        double expResult = 0.0;
        double result = instance.getFitnessPercentual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFitnessPercentual method, of class Individuo.
     */
    @Test
    public void testSetFitnessPercentual() {
        System.out.println("setFitnessPercentual");
        double fitnessPercentual = 0.0;
        Individuo instance = new Individuo();
        instance.setFitnessPercentual(fitnessPercentual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGene method, of class Individuo.
     */
    @Test
    public void testSetGene() {
        System.out.println("setGene");
        int position = 0;
        boolean gene = false;
        Individuo instance = new Individuo();
        instance.setGene(position, gene);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFaixaRoleta method, of class Individuo.
     */
    @Test
    public void testSetFaixaRoleta() {
        System.out.println("setFaixaRoleta");
        double inicio = 0.0;
        double fim = 0.0;
        Individuo instance = new Individuo();
        instance.setFaixaRoleta(inicio, fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaixaRoleta method, of class Individuo.
     */
    @Test
    public void testGetFaixaRoleta() {
        System.out.println("getFaixaRoleta");
        Individuo instance = new Individuo();
        double[] expResult = null;
        double[] result = instance.getFaixaRoleta();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mutarBit method, of class Individuo.
     */
    @Test
    public void testMutarBit() {
        System.out.println("mutarBit");
        int position = 0;
        Individuo instance = new Individuo();
        instance.mutarBit(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInt method, of class Individuo.
     */
    @Test
    public void testGetInt() {
        System.out.println("getInt");
        Individuo instance = new Individuo();
        int expResult = 0;
        int result = instance.getInt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printIndividuo method, of class Individuo.
     */
    @Test
    public void testPrintIndividuo() {
        System.out.println("printIndividuo");
        Individuo instance = new Individuo();
        String expResult = "";
        String result = instance.printIndividuo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
