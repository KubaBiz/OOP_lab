package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private final IWorldMap map;
    private  MoveDirection[] directions;
    private final ArrayList<Vector2d> kierunki;
    private App observer;
    private int moveDelay;
    private final boolean isAppOpening;

    public SimulationEngine(IWorldMap mapa, Vector2d[] positions, App app, int movedelay) {
        map = mapa;
        kierunki = new ArrayList<Vector2d>();
        observer = app;
        moveDelay = movedelay;
        isAppOpening = true;

        for (Vector2d position : positions) {
            kierunki.add(position);
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }

    public SimulationEngine(MoveDirection[] tab1, IWorldMap mapa, Vector2d[] positions){
        directions =tab1;
        map=mapa;
        kierunki = new ArrayList<Vector2d>();
        isAppOpening = false;
        for (Vector2d position : positions) {
            kierunki.add(position);
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }

    public void setDirections(MoveDirection[] tab1){ directions = tab1; }

    @Override
    public void run() {
        if(this.isAppOpening) {
            Platform.runLater(observer::updateMap);
            try {
                Thread.sleep(moveDelay);
                HashMap<Vector2d, IMapElement> elements = map.getElements();
                int animals = kierunki.size();
                if (animals > 0) {
                    for (int i = 0; i < directions.length; i++) {
                        ((Animal) (elements.get(kierunki.get(i % animals)))).move(directions[i]);
                        //animals.get(i%a).move(directions[i]);
                        if (map instanceof GrassField) {
                            ((GrassField) map).placeGrass();
                        }
                        //System.out.println(map);
                        Platform.runLater(observer::updateMap);
                        Thread.sleep(moveDelay);
                    }
                }
                Thread.sleep(3000);
                Platform.exit();

            } catch (InterruptedException e) {
                throw new RuntimeException(e + "Przerwano symulację");
            }
        }else {
            System.out.println(map);
            HashMap<Vector2d, IMapElement> elements = map.getElements();
            int animals = kierunki.size();
            if (animals > 0) {
                for (int i = 0; i < directions.length; i++) {
                    ((Animal) (elements.get(kierunki.get(i % animals)))).move(directions[i]);
                    //animals.get(i%a).move(directions[i]);
                    if (map instanceof GrassField) {
                        ((GrassField) map).placeGrass();
                    }
                    System.out.println(map);
                }
            }
        }
    }
}
