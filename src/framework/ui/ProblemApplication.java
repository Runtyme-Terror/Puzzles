/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import domains.arithmetic.ArithmeticGUI;
import domains.dummy.DummyGUI;
import domains.farmer.FarmerGUI;
import domains.puzzle.PuzzleGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 *
 * @author David Gagliardi
 */
public class ProblemApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        /* Add tabs using the following */
        Tab arithmeticTab = new Tab();
        arithmeticTab.setText("Arithmetic Problem");
        arithmeticTab.setContent(new ArithmeticGUI().getProblemGUI());
        tabPane.getTabs().add(arithmeticTab);

        Tab dummyTab = new Tab();
        dummyTab.setText("Dummy Problem");
        dummyTab.setContent(new DummyGUI().getProblemGUI());
        tabPane.getTabs().add(dummyTab);
        
        Tab farmerTab = new Tab();
        farmerTab.setText("Farmer Problem");
        farmerTab.setContent(new FarmerGUI().getProblemGUI());
        tabPane.getTabs().add(farmerTab);
        
        Tab puzzleTab = new Tab();
        puzzleTab.setText("8-Puzzle Problem");
        puzzleTab.setContent(new PuzzleGUI().getProblemGUI());
        tabPane.getTabs().add(puzzleTab);
        
        Scene scene = new Scene(tabPane);

        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}