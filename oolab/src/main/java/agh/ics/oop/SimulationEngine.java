package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private IWorldMap map;
    private MoveDirection[] directions;
    private ArrayList<Animal> animals = new ArrayList<>();
    public SimulationEngine(MoveDirection[] tab1, IWorldMap mapa, Vector2d[] positions){
        directions =tab1;
        map=mapa;
        for (Vector2d position : positions) {
            if (map.place(new Animal(map, position))) {
                animals.add((Animal)map.objectAt(position));
            }
        }
    }
    @Override
    public void run() {
        System.out.println(map);
        int a = animals.size();
        if (a>0) {
            for (int i = 0; i < directions.length; i++) {
                animals.get(i % a).move(directions[i]);
                System.out.println(map);
            }
        }
    }
}