package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldElement{
    IWorldMap map;
    private MapDirection orientation;
    private ArrayList<IPositionChangeObserver> observers;
    public Animal (IWorldMap mapa, Vector2d initialPosition){
        orientation = MapDirection.NORTH;
        map = mapa;
        position = initialPosition;
        observers = new ArrayList<>();
    }
    @Override
    public String toString(){ return orientation.toString(); }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) orientation = orientation.next();
        else if (direction == MoveDirection.LEFT) orientation = orientation.previous();
        else{
            int a = MoveDirection.FORWARD == direction ? 1 : -1;
            Vector2d tmp;
            if (a == 1){
                tmp = position.add(orientation.toUnitVector());
            }
            else {
                tmp = position.subtract(orientation.toUnitVector());
            }
            if (map.canMoveTo(tmp)){
                positionChanged(position,tmp);
                position=tmp;
            }
        }
    }
    public MapDirection getOrientation() {
        return orientation;
    }
    public ArrayList<IPositionChangeObserver> getObservers() { return new ArrayList<>(observers); }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void positionChanged(Vector2d prev, Vector2d next){
        for (IPositionChangeObserver argument: observers){
            argument.positionChanged(prev, next);
        }
    }
}
