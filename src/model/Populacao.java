/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe que define a população de individuos do AG
 * 
 * @author LuisDaniel
 */
public class Populacao {
    
    //Atributos
    private Individuo[] populacao; //Array com n individuos
    
    //Construtor

    public Populacao() {
    
        //Instancia da populacao
        this.populacao = new Individuo[Constantes.getSizePopulacao()];
    
        //Insere individuos na populacao
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            populacao[i] = new Individuo();
        }
        
        //Avaliacao da populacao
        calcularFitness();
        calcularFitnessPercent();
        calcularRangeRoleta();
    }
    
    //Getters & Setters

    public Individuo[] getPopulacao() {
        return populacao;
    }
    
    public void setIndividuo(int pos, Individuo ind){
        this.populacao[pos] = ind;
    }

    //Métodos
    
    /**
     * Cálculo do fitness médio da população
     * @return media fitness da populacao
     */
    public double getMediaPopulacao(){
        
        double sum = 0.0;
        
        for (Individuo ind : populacao) {
            sum += ind.getFitness();
        }
        
        return sum / Constantes.getSizePopulacao();
    }
    
    /**
     * Calcula o fitness da população
     */
    public void calcularFitness() {
        
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            this.populacao[i].setFitness(Constantes.function1(this.populacao[i].getInt()));
        }
    }

    /**
     * Cálculo do fitness percentual para cada elemento da populacao
     */
    public void calcularFitnessPercent() {
        
        double somatoriaFitness = 0.0;
        
        //Somatorio de todos os valores de aptidão
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            somatoriaFitness += populacao[i].getFitness();
        }
        
        //Cálculo do valor da taxa fitness em relação ao total da populaçao
        double fitPercent;
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            fitPercent = populacao[i].getFitness() * 100 / somatoriaFitness;
            populacao[i].setFitnessPercentual(fitPercent);
        }
    }

    /**
     * Calcula o range da roleta em que o individuo faz parte
     */
    public void calcularRangeRoleta() {

        //Ordenacao dos individuos em ordem crescente
        ordenarPopulacao();
        double somatoria = 0.0;
        
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            
            if (i == 0) {
                //Individuo menos apto
                somatoria += populacao[i].getFitnessPercentual();
                populacao[i].setFaixaRoleta(0, somatoria);
            } else if (i == Constantes.getSizePopulacao() - 1) {
                //Elemento mais apto
                populacao[i].setFaixaRoleta(somatoria, 100);
            } else {
                populacao[i].setFaixaRoleta(somatoria, 
                        somatoria + populacao[i].getFitnessPercentual());
                somatoria += populacao[i].getFitnessPercentual();
            }
        }
    }

    /**
     * Atualiza os valores da roleta
     */
    public void atualizarValores(){
        
        calcularFitness();
        calcularFitnessPercent();
        calcularRangeRoleta();
    }
    
    /**
     * Ordena a população em função do valor do fitness percentual
     */
    public void ordenarPopulacao() {
        Individuo aux = new Individuo();
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            for(int j = 0; j < Constantes.getSizePopulacao(); j++){
                if (populacao[i].getFitnessPercentual() < populacao[j].getFitnessPercentual()) {
                    aux = populacao[i];
                    populacao[i] = populacao[j];
                    populacao[j] = aux;
                }
            }
        }
    }
    
    /**
     * Retorna uma string com os valores da populacaos
     * @return 
     */
    public String printPopulacao(){
        
        String result = "";
        
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            result = result + populacao[i].printIndividuo() + " | " + 
                    populacao[i].getInt() + " | " + 
                    populacao[i].getFitness() + " | " + 
                    populacao[i].getFitnessPercentual() + " | " + 
                    populacao[i].getFaixaRoleta()[0] + " : " +
                    populacao[i].getFaixaRoleta()[1] + "\n";
                    
        }
        
        return result;
    }
}
