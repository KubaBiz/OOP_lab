package agh.ics.oop;

import java.util.Comparator;

public class CompareY implements Comparator<Vector2d> {

    public int compare(Vector2d first, Vector2d second) {
        if(first.equals(second)){ return 0; }
        if(first.y < second.y || (first.y == second.y && first.x < second.x)){ return -1; }
        return 1;
    }
}
