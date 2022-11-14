package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final Vector2d rozmiar;
    public List<Animal> animals = new ArrayList<>();
    public RectangularMap(int width, int height){
        rozmiar = new Vector2d(width,height);
    }

    @Override
    public boolean canMoveTo(Vector2d position){ return position.follows(new Vector2d(0, 0)) && position.precedes(rozmiar); }

    @Override
    public boolean place(Animal animal){
        if (canMoveTo(animal.position) && !isOccupied(animal.position)){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){ return objectAt(position) != null; }

    @Override
    public Object objectAt(Vector2d position){
        for (Animal arg : animals) {
            if (arg.position.equals(position)) {
                return arg;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return(new MapVisualizer(this).draw(new Vector2d(0,0),rozmiar));
    }
}
