package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    void toStringTest(){
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
    }

    @Test
    void nextTest(){
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
    }

    @Test
    void previousTest(){
        assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH);
        assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST);
    }

    @Test
    void toUnitVectorTest(){
        assertEquals(MapDirection.NORTH.toUnitVector(),new Vector2d(0,1));
        assertEquals(MapDirection.SOUTH.toUnitVector(),new Vector2d(0,-1));
        assertEquals(MapDirection.EAST.toUnitVector(),new Vector2d(1,0));
        assertEquals(MapDirection.WEST.toUnitVector(),new Vector2d(-1,0));
    }

}
