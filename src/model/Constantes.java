/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * Classe que contém as constantes utilizadas na aplicação de algoritmo genético
 * 
 * @author LuisDaniel
 */
public class Constantes {
    
    //Atributos
    private static final int SIZE_CROMOSSOMO = 9; //Tamanho do individuo
    private static final int SIZE_POPULACAO = 1000; //Tamanho da populacao
    private static int functionXSize = (int) Math.pow(2, SIZE_CROMOSSOMO); //Tamanho da função no eixo X
    public static Random random = new Random(); //Objeto randomico
    
    //Métodos
    
    /**
     * Função que será maximizada pelo algoritmo genético
     * @param x valor de aptidão do individuo
     * @return valor da função em x
     */
    public static double function1(double x){
        
        return (double) (100 + Math.abs(x * Math.sin(Math.sqrt(x))));
    }
    
    /**
     * Retorna o tamanho do cromossomo do individuo
     * @return SIZE_CROMOSSOMO as int
     */
    public static int getSizeCromossomo(){
        return SIZE_CROMOSSOMO;
    }
    
    /**
     * Retorna o tamanho de uma populaçao de individuos
     * @return SIZE_POPULACAO as int
     */
    public static int getSizePopulacao(){
        return SIZE_POPULACAO;
    }
    
    /**
     * Retorna o tamanho da função no eixo X
     * @return Tamanho da função no eixo X
     */
    public static int getXSizePopulacao(){
        return functionXSize;
    }
    
}
