package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void canMoveToTest() {
        String[] args = {"f","r","f","f","l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 3)));
        assertFalse(map.canMoveTo(new Vector2d(1, 4)));
    }

    @Test
    void placeTest() {
        String[] args = {"f","r","f","f","l","b"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        Animal animal = new Animal(map, new Vector2d(2, 4));
        Animal animal2 = new Animal(map, new Vector2d(3, 3));
        Animal animal3 = new Animal(map, new Vector2d(1,4));
        assertTrue(map.place(animal));
        System.out.println(map.toString());
        assertTrue(map.place(animal2));
        System.out.println(map.toString());
        assertFalse(map.place(animal3));
        System.out.println(map.toString());
    }

    @Test
    void isOccupiedTest() {
        String[] args = {"f","r","f","f","l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(1, 4)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        Animal animal = new Animal(map, new Vector2d(2, 4));
        assertFalse(map.isOccupied(new Vector2d(2, 4)));
        map.place(animal);
        assertTrue(map.isOccupied(new Vector2d(2, 4)));
    }

    @Test
    void objectAtTest() {
        String[] args = {"f","r","f","f","l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        RectangularMap map1 = (RectangularMap) map;
        HashMap<Vector2d,IMapElement> animals1 = map1.getElements();
        assertNotEquals(map.objectAt(new Vector2d(2, 3)), animals1.get(new Vector2d(2, 3)));
        assertEquals(map.objectAt(new Vector2d(1, 4)), animals1.get(new Vector2d(1, 4)));
        assertEquals(map.objectAt(new Vector2d(3, 3)), animals1.get(new Vector2d(3, 3)));
        assertNull(map.objectAt(new Vector2d(0, 0)));
    }
}
