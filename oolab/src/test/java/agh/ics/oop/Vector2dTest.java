package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equalsTest(){
        Vector2d first = new Vector2d(1,0);
        Vector2d second = new Vector2d(0,1);
        assertNotEquals(first,second);
        assertTrue(first.equals(first));
        assertFalse(first.equals(second));
    }

    @Test
    void toStringTest(){
        Vector2d first = new Vector2d(1,0);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.toString(),"(1,0)");
        assertEquals(second.toString(),"(0,1)");
        assertEquals(third.toString(),"(3,4)");
    }

    @Test
    void precedesTest(){
        Vector2d first = new Vector2d(1,0);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertFalse(first.precedes(second));
        assertTrue(second.precedes(third));
        assertTrue(third.precedes(third));
    }

    @Test
    void followsTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertFalse(first.follows(second));
        assertTrue(third.follows(second));
        assertTrue(first.follows(first));
    }

    @Test
    void upperRightTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.upperRight(second),new Vector2d(1,1));
        assertEquals(first.upperRight(third),new Vector2d(3,4));
        assertEquals(third.upperRight(second),new Vector2d(3,4));
    }

    @Test
    void lowerLeftTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.lowerLeft(second),new Vector2d(0,-1));
        assertEquals(first.lowerLeft(third),new Vector2d(1,-1));
        assertEquals(third.lowerLeft(second),new Vector2d(0,1));
    }

    @Test
    void addTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.add(second),new Vector2d(1,0));
        assertEquals(first.add(third),new Vector2d(4,3));
        assertEquals(third.add(second),new Vector2d(3,5));
    }

    @Test
    void subtractTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.subtract(second),new Vector2d(1,-2));
        assertEquals(first.subtract(third),new Vector2d(-2,-5));
        assertEquals(third.subtract(second),new Vector2d(3,3));
    }

    @Test
    void oppositeTest(){
        Vector2d first = new Vector2d(1,-1);
        Vector2d second = new Vector2d(0,1);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.opposite(),new Vector2d(-1,1));
        assertEquals(second.opposite(),new Vector2d(0,-1));
        assertEquals(third.opposite(),new Vector2d(-3,-4));
    }
}
