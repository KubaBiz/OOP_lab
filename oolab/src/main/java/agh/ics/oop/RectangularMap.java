package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height){
        min_position = new Vector2d(0, 0);
        max_position = new Vector2d(width, height);
        left_corner = min_position;
        right_corner = max_position;
    }
}
