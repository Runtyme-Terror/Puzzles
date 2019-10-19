/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import framework.problem.Benchmark;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solution;
import framework.solution.Solver;
import framework.solution.StateSpaceSolver;
import framework.solution.Statistics;
import java.util.ArrayList;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author David Gagliardi
 */
public class ProblemGUI extends BorderPane {
    
    public ProblemGUI(Problem problem, double width, double height) {
    this.problem = problem;
    this.setPrefSize(width, height);
   // benchmarks = problem.getBenchmarks();
    nextButton = new Button("Next");
    bfs = new StateSpaceSolver(problem, true);
    dfs = new StateSpaceSolver(problem, false);
   // aSolver = new AStarSolver(this.problem);
    solver = bfs;
    
    
    
    BorderPane layout = new BorderPane(getMoves(problem));
    layout.setTop(getIntro(problem));
    layout.setLeft(getState(problem));
    layout.setRight(getGoal(problem));
    layout.setBottom(getInfo(problem));
    
    BorderPane.setAlignment(layout.getTop(), Pos.CENTER);
    BorderPane.setAlignment(layout.getBottom(), Pos.CENTER);
    BorderPane.setAlignment(layout.getLeft(), Pos.CENTER_LEFT);
    BorderPane.setAlignment(layout.getRight(), Pos.CENTER_RIGHT);
    BorderPane.setAlignment(layout.getCenter(), Pos.CENTER);
   
    super.getChildren().add(layout);
    }
    /*
    * Getter for the introduction for the current problem.
    *
    *
    * @return the introduction VBox pane
    */
    private VBox getIntro(Problem problem)
    {
        VBox vbox = new VBox(50);
        vbox.setPadding(new Insets(8));
        vbox.setAlignment(Pos.CENTER);
        
        Text text = new Text("Welcome to the " + problem.getName() + "Problem");
        text.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
        
        Text introduction = new Text(problem.getIntroduction());
        introduction.setFont(new Font(15));
        introduction.setFont(Font.font("Monospaced"));
        introduction.setWrappingWidth(500);
        
        vbox.getChildren().addAll(text, introduction);
        
        return vbox;
    }
    
   /*
    * Getter for the final state representation for the current problem.
    *
    *
    * @return the final state's VBox pane
    */
    private VBox getGoal(Problem problem)
    {
      
        
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER_RIGHT);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        
        Text text = new Text("Goal State");
        text.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
        
        finalState = setStateLabel(problem.getFinalState().toString());
        vbox.getChildren().addAll(text, finalState);
              

        return vbox;
    }
    
   /*
    * Getter for the current state representation for the current problem.
    *
    *
    * @return the current state's VBox pane
    */
    private VBox getState(Problem problem)
    {
        
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(10,10,10,10));
        
        Text text = new Text("Current State");
        text.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
        
        currentState = setStateLabel(problem.getCurrentState().toString());
        vbox.getChildren().addAll(text, currentState);
                
      
        
        return vbox;
    }
    
    /*
    * Getter for the reset button and success/illegal messages for the current problem.
    *
    *
    * @return the success/illegal move and reset button VBox pane
    */
    private HBox getInfo(Problem problem)
    {
        

        HBox hbox = new HBox();
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(0,0,0,0));
        vbox.setAlignment(Pos.TOP_CENTER);
        
        TextArea responder = new TextArea();
        responder.setEditable(false);
        responder.setMaxSize(400, 500);
        responder.setPromptText("<Nothing yet.>");
        
        Button solveButton = new Button("Solve");
        solveButton.setOnAction(event -> {
            solveButton.setDisable(true);
            solver.solve();
            solution = solver.getSolution();
            statistics = solver.getStatistics();
            if (breadth) {
                statistics.setHeader("Breadth-First State Space Search\n"
                        + "------------------");
            } else if (aStar) {
                statistics.setHeader("A-Star State Space Search\n"
                        + "------------------");
            } else {
                statistics.setHeader("Depth-First State Space Search\n"
                        + "------------------");
            }
            problem.setCurrentState((State) solution.next().getData());
            updateState(problem);
            responder.setText(statistics.toString());
                });
        
        
        nextButton.disableProperty().bind(Bindings.not(solveButton.disableProperty()));
        nextButton.setOnAction(event -> {            
             problem.setCurrentState((State) solution.next().getData());
             updateState(problem);
                });
        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> {
            reset(problem);
            solveButton.setDisable(false);
                });
        
        
        successText = new Text("                                        ");        
        successText.setFont(new Font(20));
        successText.setFont(Font.font("Monospaced"));
        vbox.getChildren().addAll(successText, solveButton, nextButton, resetButton); 
        
        ChoiceBox<String> searchType = new ChoiceBox<>();
        searchType.getItems().addAll("Breadth-First Search", "Depth-First Search", "A* Search");
        searchType.setValue("Breadth-First Search");
        
        ObservableValue<String> selectedValue
            = searchType.valueProperty();
        selectedValue.addListener((ev) -> {
          if ("Breadth-First Search".equals(searchType.getValue())) {
              solver = bfs;
              breadth = true;
          } else if ("Depth-First Search".equals(searchType.getValue())) {
              solver = dfs;
              breadth = false;
          } /*else {
              solver = aSolver;
              aStar = true;              
          }*/
        });
        
//        ChoiceBox<String> benchmarkOptions = new ChoiceBox<>();
//        for (int i = 0; i <= 8; ++i) {
//        benchmarkOptions.getItems().add(benchmarks.remove(i).toString());
//        }
//        ObservableValue<String> benchValue = benchmarkOptions.valueProperty();
//        benchValue.addListener((ev) -> {
//                        
//        });

        hbox.getChildren().addAll(vbox, searchType, /*benchmarkOptions,*/ responder);
  
                
        return hbox;
    }
    
    /*
    * Getter for the Move representation for the current problem.
    *
    *
    * @return the VBox pane for the problem's moves as buttons
    */
    
    private VBox getMoves(Problem problem)
    {
        
        final double adj = new Text("").getLayoutBounds().getHeight();
        
        VBox vbox = new VBox(8);
        vbox.setPadding(new Insets(40));
        vbox.setAlignment(Pos.CENTER);
        
        VBox buttons = new VBox(0.8 * adj);
        Mover problemMover = problem.getMover();
        for (int i = 0; i < problemMover.getMoveNames().size(); i++) {
            String moveName = problemMover.getMoveNames().get(i);
            Button b = new Button(moveName);
            b.setMinWidth(150);
            b.setWrapText(true);
            b.disableProperty().bind(Bindings.not(nextButton.disableProperty()));

            b.setOnAction(event -> {
                successText.setText("                                        ");
                next = problemMover.doMove(moveName, problem.getCurrentState());
                if (next != null) {
                    problem.setCurrentState(problemMover.doMove(moveName, problem.getCurrentState()));
                    updateState(problem);
                } else {
                    illegalMove();
                }
            });
            buttons.getChildren().add(b);
        }
        
        movesText = new Label("Moves (" + moves + " so far):");
        movesText.setFont(new Font(12));
        movesText.setFont(Font.font("Monospaced"));
        vbox.getChildren().addAll(movesText, buttons); 
        
        
                
        return vbox;
    }
    
    private void updateState(Problem problem) {
        currentState.setText(null);
        currentState.setText(setStateLabel(problem.getCurrentState().toString()).getText());
        moves++;
        movesText.setFont(Font.font("Monospaced"));
        movesText.setText("Moves (" + moves + " so far):");

        if (problem.getCurrentState().equals(problem.getFinalState())) {
            problemSuccess();
        }
    }

    //Display success
    private void problemSuccess() {
        successText.setText("You solved the problem. Congratulations.");
        successText.setFill(Color.RED);        
    }
    
    //Display illegal move
    private void illegalMove() {
        successText.setText("       Illegal move, try again.         ");
        successText.setFill(Color.RED);        
    }

    //Reset problem to initial conditions
    private void reset(Problem problem) {
        moves = -1;
        problem.setCurrentState(problem.getInitialState());
        updateState(problem);
        successText.setText("                                        ");
    }

    /*
    * Setter for the state label representation for the current problem.
    *
    *
    * @return the state's current Label
    */
    private Label setStateLabel(String text) {
        Label t = new Label(text);
        t.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        t.setPadding(new Insets(5));
        t.setFont(Font.font("Monospaced", 24));
        return t;
    }
    
    private State next;
    private Label currentState, finalState, movesText;
    private Text successText;
    private final Problem problem;
    private int moves = 0;
    private Solver solver;
    StateSpaceSolver bfs;
    StateSpaceSolver dfs;
    Solution solution;
    Statistics statistics;
    boolean breadth = true;
    boolean aStar = false;
    Button nextButton;
    //AStarSolver aSolver;
    //ArrayList<Benchmark> benchmarks;
}