package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final MoveDirection[] directions;
    private final ArrayList<Vector2d> kierunki;
    public SimulationEngine(MoveDirection[] tab1, IWorldMap mapa, Vector2d[] positions){
        directions =tab1;
        map=mapa;
        kierunki = new ArrayList<Vector2d>();
        for (Vector2d position : positions) {
            kierunki.add(position);
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }
    @Override
    public void run() {
        System.out.println(map);
        HashMap<Vector2d,IMapElement> elements = map.getElements();
        int a = kierunki.size();
        if (a>0) {
            for (int i = 0; i < directions.length; i++) {
                ((Animal)(elements.get(kierunki.get(i%a)))).move(directions[i]);
                //animals.get(i%a).move(directions[i]);
                if (map instanceof GrassField){
                    ((GrassField) map).placeGrass();
                }
                System.out.println(map);
            }
        }
    }
}
