package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final MoveDirection[] directions;
    public SimulationEngine(MoveDirection[] tab1, IWorldMap mapa, Vector2d[] positions){
        directions =tab1;
        map=mapa;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }
    @Override
    public void run() {
        System.out.println(map);
        ArrayList<Animal> animals = map.getAnimals();
        int a = animals.size();
        if (a>0) {
            for (int i = 0; i < directions.length; i++) {
                animals.get(i%a).move(directions[i]);
                if (map instanceof GrassField){
                    ((GrassField) map).placeGrass();
                }
                System.out.println(map);
            }
        }
    }
}
