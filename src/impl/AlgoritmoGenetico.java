/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import java.util.ArrayList;
import java.util.List;
import model.Constantes;
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
    
        //Início do algoritmo
        //Avaliação da populacao
        Populacao novaPopulacao = new Populacao();
        List<Individuo> popAux = new ArrayList<>();
        
        for (int i = 0; i < Constantes.getSizePopulacao() / 2; i++) {
            
            //Seleciona os pais para o cruzamento
            Individuo pai = roleta(pop);
            Individuo mae = roleta(pop);
            
            //Realiza o cruzamento
            Individuo[] filhos = crossover(pai, mae);
            
            //Aplica a mutacao
            Individuo filhoA = mutacao(filhos[0]);
            Individuo filhoB = mutacao(filhos[1]);
            
            popAux.add(filhoA);
            popAux.add(filhoB);
        }
        
        //Apagar velhos membros e inserir novos membros
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            novaPopulacao.setIndividuo(i, popAux.get(i));
        }
        popAux = null;
        
        //Reavaliar a populacao
        novaPopulacao.atualizarValores();
        
        return novaPopulacao;
    }

    /**
     * Método para procurar um indivíduo a partir da população, sendo esse
     * individuo retornado conforme sorteio
     * @param pop uma população de indivíduos
     * @return Um indivíduo da população se estiver dentro da faixa da roleta
     * e null caso não exista individuo, porém caso isso ocorra há um erro na aplicacao
     */
    private Individuo roleta(Populacao pop) {
        
        double numSorteado = Constantes.random.nextDouble() * 100;
        
        for (Individuo ind : pop.getPopulacao()) {
            if(numSorteado >= ind.getFaixaRoleta()[0] && numSorteado <= ind.getFaixaRoleta()[1]){
                return ind;
            }
        }
        
        return null;
    }

    /**
     * Realiza o crossover (cruzamento) entre individuos
     * @param pai
     * @param mae
     * @return os filhos do cruzamento (par)
     */
    private Individuo[] crossover(Individuo pai, Individuo mae) {
        
        Individuo[] novoInd = new Individuo[2];
        
        //ponto de corte dos cromossomos dos individuos
        int pontoDeCorte = Constantes.random
                .nextInt(Constantes.getSizeCromossomo() - 1);
        
        //Individuos pai e mae auxiliares
        Individuo paiAux = new Individuo();
        Individuo maeAux = new Individuo();
        
        novoInd[PAI] = new Individuo();
        novoInd[MAE] = new Individuo();
        
        for (int i = 0; i < Constantes.getSizeCromossomo(); i++) {
            paiAux.setGene(i, pai.getGene(i));
            maeAux.setGene(i, mae.getGene(i));
        
            //Define uma copia para os individuos filhos, evitando perdas de memoria
            novoInd[PAI].setGene(i, pai.getGene(i));
            novoInd[MAE].setGene(i, mae.getGene(i));
        }
        
        //Verifica se o individuo está na taxa de crossover
        if (Constantes.random.nextDouble() < taxaCrossover) {
            //Validacao do ponto de corte
            //System.out.println("Caiu na taxa de crossover. Ponto de corte " + pontoDeCorte);
            for (int i = pontoDeCorte; i < Constantes.getSizeCromossomo(); i++) {
                novoInd[PAI].setGene(i, maeAux.getGene(i));
                novoInd[MAE].setGene(i, paiAux.getGene(i));
            }
        }
        
        return novoInd;
    }
    
    /**
     * Verifica se o individuo está dentro da taxa de mutacao. Caso positivo 
     * realiza a mutacao.
     * Caso o individuo esteja dentro da taxa de mutacao realiza a mutacao, 
     * caso contrario retorna o mesmo individuo
     * @param individuo individuo a ser mutado
     * @return individuo mutado (ou nao)
     */
    private Individuo mutacao(Individuo individuo) {
        //Verifica se o individuo cai na taxa de mutacao
        if (Constantes.random.nextDouble() <= taxaMutacao) {
            int genePosition = Constantes.random.nextInt(Constantes.getSizeCromossomo() - 1);
            individuo.mutarBit(genePosition);
        }
        
        return individuo;
    }
}
