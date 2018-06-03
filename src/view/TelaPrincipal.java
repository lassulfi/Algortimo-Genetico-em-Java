/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import impl.AlgoritmoGenetico;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Constantes;
import model.Populacao;

/**
 *
 * @author LuisDaniel
 */
public class TelaPrincipal extends Application {
    
    //Atributos
    private Populacao pop;
    
    private static final String DEFAULT_CROSSOVER_RATE = "0.80";
    private static final String DEFAULT_MUTATION_RATE = "0.01";
    private static final String DEFAULT_EVOLUTIONS = "100";
    
    private Button btnCriarPopulacao = new Button("Criar população");
    private Button btnExecutarAlgoritmo = new Button("Executar algoritmo genético");
    
    private TextField txtCrossover = new TextField(DEFAULT_CROSSOVER_RATE);
    private TextField txtMutacao = new TextField(DEFAULT_MUTATION_RATE);
    private TextField txtEvolucoes = new TextField(DEFAULT_EVOLUTIONS);
    
    private LineChart<Number, Number> populacaoLineChart;
    private XYChart.Series curvaFuncaoPopulacao;
    private XYChart.Series populacaoGrafico;
    private LineChart<Number, Number> mediaPopulacaoLineChart;
    private XYChart.Series mediaPopulacaoGrafico;
    
    private TextArea txtMelhoresIndividuos = new TextArea();
    private TextArea txtPioresIndividuos = new TextArea();
            
    @Override
    public void start(Stage primaryStage) {
        
        Label lbl1 = new Label("Taxa de crossover");
        Label lbl2 = new Label("Taxa de mutação");
        Label lbl3 = new Label("Evoluções");
        
        //Configuração dos botoes
        btnCriarPopulacao.setMaxWidth(Double.MAX_VALUE);
        btnCriarPopulacao.setOnAction((ActionEvent e) -> {
            btnCriarPopulacaoClick();
        });
        btnExecutarAlgoritmo.setMaxWidth(Double.MAX_VALUE);
        btnExecutarAlgoritmo.setDisable(true);
        btnExecutarAlgoritmo.setOnAction((ActionEvent e) -> {
            btnExecutarAlgoritmoClick();
        });
        
        //GridPane para os dados da aplicação
        GridPane gp1 = new GridPane();
        gp1.setMinSize(100, 100);
        gp1.setPadding(new Insets(10));
        gp1.setVgap(10);
        gp1.setHgap(5);
        gp1.add(lbl1, 0, 0);
        gp1.add(txtCrossover, 1, 0);
        gp1.add(lbl2, 0, 1);
        gp1.add(txtMutacao, 1, 1);
        gp1.add(lbl3, 0, 2);
        gp1.add(txtEvolucoes, 1, 2);
 
        VBox leftVBox = new VBox();
        leftVBox.getChildren().addAll(gp1, btnCriarPopulacao, btnExecutarAlgoritmo);
        leftVBox.setSpacing(5);
        leftVBox.setPadding(new Insets(10));
        leftVBox.setAlignment(Pos.TOP_CENTER);
        
        //Configuração dos gráficos
        //Grafico da populacao
        NumberAxis populacaoXAxis = new NumberAxis();
        populacaoXAxis.setLabel("Gerações");
        NumberAxis populacaoYAxis = new NumberAxis();
        populacaoYAxis.setLabel("Indivíduos");
        
        populacaoLineChart = new LineChart(populacaoXAxis, populacaoYAxis);
        populacaoLineChart.setTitle("Evolução da População");
        
        curvaFuncaoPopulacao = new XYChart.Series();
        curvaFuncaoPopulacao.setName("Função para Maximização");
        
        //Exibe no gráfico o diagrama da função
        for (int i = 0; i < Constantes.getXSizePopulacao(); i++) {
            curvaFuncaoPopulacao.getData()
                    .add(new XYChart.Data(i, Constantes.function1(i)));
            
        }
        populacaoLineChart.getData().add(curvaFuncaoPopulacao);
        
        populacaoGrafico = new XYChart.Series();
        populacaoGrafico.setName("Indivíduos");
        
        //Grafico da media da populacao
        NumberAxis mediaPopulacaoXAxis = new NumberAxis();
        mediaPopulacaoXAxis.setLabel("Gerações");
        NumberAxis mediaPopulacaoYAxis = new NumberAxis();
        mediaPopulacaoYAxis.setLabel("Média Fitness");
        mediaPopulacaoLineChart = new LineChart(mediaPopulacaoXAxis, mediaPopulacaoYAxis);
        mediaPopulacaoLineChart.setTitle("Média da População");
        mediaPopulacaoLineChart.setCreateSymbols(false);
        
        Label lbl4 = new Label("Melhores indivíduos");
        Label lbl5 = new Label("Piores indivíduos");
        
        //GripPane para os gráficos
        GridPane gp2 = new GridPane();
        gp2.setMinSize(1000, 800);
        gp2.setPadding(new Insets(10));
        gp2.setVgap(10);
        gp2.setHgap(5);
        gp2.add(populacaoLineChart, 0, 0);
        gp2.add(mediaPopulacaoLineChart, 1, 0);
        gp2.add(lbl4, 0, 1);
        gp2.add(lbl5, 1, 1);
        gp2.add(txtMelhoresIndividuos, 0, 2);
        gp2.add(txtPioresIndividuos, 1, 2);
        
        //BorderPane principal
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftVBox);
        borderPane.setCenter(gp2);
        
        Scene scene = new Scene(borderPane, 1500, 700);
        //Procura o arquivo estilo.css para adicinar a scene
        URL estiloUrl = this.getClass().getResource("estilo.css");
        if (estiloUrl != null) {
            String css = estiloUrl.toExternalForm();
            scene.getStylesheets().add("css");
        }     
        
        primaryStage.setTitle("Algortimo Genetico");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Cria uma população na aplicação
     */
    private void btnCriarPopulacaoClick(){
    
        //Instancia da nova população
        pop = new Populacao();
        
        //Exibe o gráfico da populacao
        populacaoGrafico.getData().clear();
        for (int i = 0; i < Constantes.getSizePopulacao(); i++) {
            populacaoGrafico.getData()
                    .add(new XYChart.Data(pop.getPopulacao()[i].getInt(), 
                            pop.getPopulacao()[i].getFitness()));
        }
        
        populacaoLineChart.getData().add(populacaoGrafico);
        
         //Habilita o botão de executar o Algoritmo
        btnExecutarAlgoritmo.setDisable(false);
               
    }
    
    /**
     * Executa o algoritmo genético ao clicar no botão btnExecutarAlgoritmo
     */
    private void btnExecutarAlgoritmoClick(){
        
        //Recupera os elementos das EditText
        double taxaMutacao = Double.parseDouble(txtMutacao.getText());
        double taxaCrossover = Double.parseDouble(txtCrossover.getText());
        int iteracoes = Integer.parseInt(txtEvolucoes.getText());
        
        //Instancia do algoritmo genetico
        AlgoritmoGenetico ag = new AlgoritmoGenetico(taxaCrossover, taxaMutacao);
        
        mediaPopulacaoGrafico = new XYChart.Series();
        
        for (int i = 0; i < iteracoes; i++) {
            
            //Cria uma nova populacao
            pop = ag.executarAlgoritmo(pop);
            
            //TODO: implementar gráfico
            mediaPopulacaoGrafico.getData()
                    .add(new XYChart.Data(i, pop.getMediaPopulacao()));
            
        }
        mediaPopulacaoLineChart.getData().add(mediaPopulacaoGrafico);
        mediaPopulacaoGrafico.setName("Média Fitness da População");
        
        //Selecao dos melhores e piores individuos
        pop.ordenarPopulacao();
        
        String pioresIndividuos = "";
        for (int i = 0; i < 10; i++) {
            pioresIndividuos += pop.getPopulacao()[i].printIndividuo() + "\n";
        }
        txtPioresIndividuos.setText(pioresIndividuos);
        
        String melhoresIndividuos = "";
        for (int i = Constantes.getSizePopulacao() - 1; i > (Constantes.getSizePopulacao() - 1) -10; i--) {
            melhoresIndividuos += pop.getPopulacao()[i].printIndividuo() + "\n";
        }
        txtMelhoresIndividuos.setText(melhoresIndividuos);
    }
    
}
