package agh.ics.oop;

abstract class AbstractWorldElement implements IMapElement{
    public Vector2d position;
    public Vector2d getPosition(){
        return position;
    }
}
