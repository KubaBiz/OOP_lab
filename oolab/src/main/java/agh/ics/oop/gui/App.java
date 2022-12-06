package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;


public class App extends Application {
    private Label label;
    private GridPane grid = new GridPane();
    private IWorldMap myMap;
    private final int width = 25;
    private final int height = 25;
    private String drawObject(Vector2d position) {
        if (this.myMap.isOccupied(position)) {
            Object object = this.myMap.objectAt(position);
            if (object != null) return object.toString();
        }
        return " ";
    }

    private void drawMap(Stage primaryStage){
        grid.setGridLinesVisible(true);
        GrassField myMap = (GrassField) this.myMap;
        int rangeY = myMap.getUpperRight().y - myMap.getLowerLeft().y;
        int rangeX = myMap.getUpperRight().x - myMap.getLowerLeft().x;
        for (int i = 0; i <= rangeY; i++) {
            int value = myMap.getUpperRight().y-i;

            label = new Label(Integer.toString(value));
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            grid.getRowConstraints().add(new RowConstraints(height));
            grid.add(label, 0, i+1);

            GridPane.setHalignment(label, HPos.CENTER);
            for (int j = 0; j < rangeX+1; j++) {
                if (i == 0) {
                    value = myMap.getLowerLeft().x + j;
                    label = new Label(Integer.toString(value));
                    grid.add(label, j+1, 0);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                String result = drawObject(new Vector2d(j+myMap.getLowerLeft().x , i+myMap.getLowerLeft().y));
                label = new Label(result);
                grid.add(label, j+1, rangeY-i+1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
        label = new Label("x/y");
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));
        grid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);

        Scene scene = new Scene(grid, (rangeX+2)*width*1.02, (rangeY+2)*height*1.02);
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println(this.myMap.toString());
        System.out.println();
        System.out.println("System zakończył działanie");
    }

    public void start(Stage primaryStage) {
            try {
                List<String> arguments = getParameters().getRaw();
                String[] args = arguments.toArray(new String[0]);
                MoveDirection[] directions = new OptionsParser().parse(args);
                IWorldMap map = new GrassField(10);
                myMap = map;
                Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
                IEngine engine = new SimulationEngine(directions, myMap, positions);
                engine.run();
                drawMap(primaryStage);
            } catch(IllegalArgumentException ex) {
                System.out.println(ex);
            }

    }
}
