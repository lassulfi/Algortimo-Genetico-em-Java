/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import java.util.ArrayList;
import java.util.List;
import model.Individuo;
import model.Populacao;

/**
 * Classe de implementacao do algoritmo genetico
 * @author LuisDaniel
 */
public class AlgoritmoGenetico {
    
    //Atributos
    private double taxaCrossover;
    private double taxaMutacao;
    
    private static final int PAI = 0;
    private static final int MAE = 1;
    
    //Construtor
    public AlgoritmoGenetico(double taxaCrossover, double taxaMutacao) {
        this.taxaCrossover = taxaCrossover;
        this.taxaMutacao = taxaMutacao;
    }
    
    //Métodos
    /**
     * Executa o algoritmo genetico
     * @param pop
     * @return 
     */
    public Populacao executarAlgoritmo(Populacao pop){
    
        Populacao novaPopulacao = new Populacao();
        List<Individuo> popAux = new ArrayList<>();
        
        
        
        return null;
    }
}
