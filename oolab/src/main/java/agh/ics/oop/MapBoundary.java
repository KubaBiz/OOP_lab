package agh.ics.oop;

import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private final TreeSet<Vector2d> xAxis = new TreeSet<>(new CompareX());
    private final TreeSet<Vector2d> yAxis = new TreeSet<>(new CompareY());

    protected void addElementToMap(Vector2d vector){
        xAxis.add(vector);
        yAxis.add(vector);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        xAxis.remove(oldPosition);
        yAxis.remove(oldPosition);
        addElementToMap(newPosition);
    }

    public Vector2d lowerLeftCheck(){ return xAxis.first().lowerLeft(yAxis.first()); }

    public Vector2d upperRightCheck(){ return xAxis.last().upperRight(yAxis.last()); }

}
