package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveToTest() {
        String[] args = {"f","r","f","f","l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
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
        IWorldMap map = new GrassField( 10);
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
        IWorldMap map = new GrassField( 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1, 4)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        Animal animal = new Animal(map, new Vector2d(2, 4));
        map.place(animal);
        assertTrue(map.isOccupied(new Vector2d(2, 4)));
    }

    @Test
    void objectAtTest() {
        String[] args = {"f","r","f","f","l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField( 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();
        GrassField map1 = (GrassField) map;
        HashMap<Vector2d,IMapElement> animals1 = map1.getElements();
        assertNotEquals(map.objectAt(new Vector2d(2, 3)), animals1.get(new Vector2d(2, 3)));
        assertEquals(map.objectAt(new Vector2d(1, 4)), animals1.get(new Vector2d(1, 4)));
        assertEquals(map.objectAt(new Vector2d(3, 3)), animals1.get(new Vector2d(3, 3)));
    }
    @Test
    void placeGrassTest() {
        String[] arr = {"f", "l", "r","f","f","r","r","f","l","f","f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(arr);
        IWorldMap mapa = new GrassField(10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2, 3)};
        IEngine engine = new SimulationEngine(directions, mapa, positions);
        engine.run();
        assertFalse(((GrassField) mapa).placeGrass());
        assertTrue(mapa.place(new Animal(mapa,new Vector2d(3,3))));
    }
}
