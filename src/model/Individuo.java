/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.BitSet;

/**
 * Classe que define um individuo da população a ser avaliada pelo algoritmo genético
 * @author LuisDaniel
 */
public class Individuo {
    
    //Atributos
    private BitSet cromossomo; //Vetor de bits, possui apenas 2 estados (true or false)
    private double fitness; //Nota de aptidão do individuo
    private double fitnessPercentual; //Taxa de aptidão do individuo
    private double[] faixaRoleta = {0, 0}; //Faixa da pizza em que é provável que o individuo seja selecionado
    
    //Construtor
    public Individuo(){
        //Instancia da classe constantes
        //Instancia do cromossomo com a quantidade de bits na classe Contantes
        this.cromossomo = new BitSet(Constantes.getSizeCromossomo());
        //Cria os genes do cromossomo (bits aleatórios)
        for (int i = 0; i < cromossomo.length(); i++) {
            this.cromossomo.set(i, (Constantes.random.nextDouble() > 0.5) ? true : false);
        }
    }
    
    //Getters & Setters
    /**
     * Retorna o bitset de cromosssomos
     * @return 
     */
    public BitSet getCromossomo() {
        return cromossomo;
    }

    /**
     * recupera o valor do fitness
     * @return 
     */
    public double getFitness() {
        return fitness;
    }

    /**
     * Define o valor do fitness
     * @param fitness 
     */
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    /**
     * Recupera a taxa de fitness percentual
     * @return 
     */
    public double getFitnessPercentual() {
        return fitnessPercentual;
    }

    /**
     * Define a taxa de fitness percentual
     * @param fitnessPercentual 
     */
    public void setFitnessPercentual(double fitnessPercentual) {
        this.fitnessPercentual = fitnessPercentual;
    }  
    
    /**
     * Insere um valor booleano em uma determinada posicao do vetor de cromossomos
     * @param position posicao (int)
     * @param gene valor booleano
     */
    public void setGene(int position, boolean gene){
        this.cromossomo.set(position, gene);
    }
    
    /**
     * Define o range da roleta
     * @param inicio
     * @param fim 
     */
    public void setFaixaRoleta(double inicio, double fim){
        this.faixaRoleta[0] = inicio;
        this.faixaRoleta[1] = fim;
    }
    
    /**
     * Retorna o range da roleta
     * @return 
     */
    public double[] getFaixaRoleta() {
        return faixaRoleta;
    } 
 
    //Métodos
    
    /**
     * Realiza a mutação de um determinado bit
     * @param position posicao a ser mutada
     */
    public void mutarBit(int position){
        if (position < cromossomo.length()) {
            cromossomo.set(position, cromossomo.get(position) == false ? true : false);
        }
    }
    
    /**
     * Retorna o valor decimal do array de bits
     * Esse valor é utilizado para avaliar a aptidao do individuo
     * @return 
     */
    public int getInt(){
        
        if (cromossomo.size() > 32) {
            throw new IllegalArgumentException("O cromossomo deve ter no máximo 32 bits");
        }
        
        return cromossomo.size();
    }
    
    /**
     * Retorna uma String com todas as características do individuo
     * @return 
     */
    public String printIndividuo(){
        String result = "";
        
        result += " BITS: ";
        for(int i = 0; i < cromossomo.length(); i++){
            result += cromossomo.get(i) == false ? 0 : 1;
        }
        
        result += " | INT: " + getInt();
        result += " | APTIDAO: " + getFitness();
        result += " | TAXA DE APTIDAO: " + getFitnessPercentual();
        
        return result;
    }
    
}
