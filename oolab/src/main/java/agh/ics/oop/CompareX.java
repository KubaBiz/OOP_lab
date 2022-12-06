package agh.ics.oop;

import java.util.Comparator;

public class CompareX implements Comparator<Vector2d> {

    public int compare(Vector2d first, Vector2d second) {
        if(first.equals(second)){ return 0; }
        if(first.x < second.x || (first.x == second.x && first.y < second.y)){ return -1; }
        return 1;
    }
}
