package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d,IMapElement> elements = new HashMap<>();
    protected ArrayList<Animal> animals = new ArrayList<>();
    protected Vector2d min_position;
    protected Vector2d max_position;
    protected Vector2d right_corner;
    protected Vector2d left_corner;

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(left_corner) && position.precedes(right_corner) && !this.isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()) && !isOccupied(animal.getPosition())){
            elements.put(animal.getPosition(), animal);
            animals.add(animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) { return objectAt(position)!=null; }
    @Override
    public Object objectAt(Vector2d position) {
        if(elements.containsKey(position)){return elements.get(position);}
        return null;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) objectAt(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, animal);
    }
    @Override
    public String toString() {
        return(new MapVisualizer(this).draw(min_position, max_position));
    }

    public ArrayList<Animal> getAnimals(){
        return new ArrayList<>(animals);
    }

    public Vector2d get_min_position(){
        return min_position;
    }
    public Vector2d get_max_position(){
        return max_position;
    }
    public HashMap<Vector2d, IMapElement> getElements() {
        return new HashMap<>(elements);
    }
}