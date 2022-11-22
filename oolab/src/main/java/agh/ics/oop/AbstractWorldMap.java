package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
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
            animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) { return objectAt(position)!=null; }
    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
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
}