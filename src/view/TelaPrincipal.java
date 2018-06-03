/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private Button btnExecutarAlgoritmo = new Button("Executar algoritmo genetico");
    
    private TextField txtCrossover = new TextField(DEFAULT_CROSSOVER_RATE);
    private TextField txtMutacao = new TextField(DEFAULT_MUTATION_RATE);
    private TextField txtEvolucoes = new TextField(DEFAULT_EVOLUTIONS);
    
    @Override
    public void start(Stage primaryStage) {
        
        Label lbl1 = new Label("Taxa de crossover");
        Label lbl2 = new Label("Taxa de mutação");
        Label lbl3 = new Label("Evoluções");
        
        //Configuração dos botoes
        btnCriarPopulacao.setMaxWidth(Double.MAX_VALUE);
        btnExecutarAlgoritmo.setMaxWidth(Double.MAX_VALUE);
        
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
        
        //BorderPane principal
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftVBox);
        
        Scene scene = new Scene(borderPane, 1500, 700);
        
        primaryStage.setTitle("Algortimo Genetico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
