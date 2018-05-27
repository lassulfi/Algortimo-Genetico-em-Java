/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Individuo;
import model.Populacao;

/**
 *
 * @author LuisDaniel
 */
public class Main {
    
    public static void main(String[] args) {
        
        Individuo individuo = new Individuo();
        
        Populacao pop = new Populacao();
        
        System.out.println(pop.printPopulacao());
        
        
        
    }
    
}
