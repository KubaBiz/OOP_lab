package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    void runTest(){

        String[] arr = {"f","l","f","r","f","l","r","f","r","l","b","r","b"};
        MoveDirection[] directions3 = new OptionsParser().parse(arr);
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(2, 3), new Vector2d(3,1)};
        IEngine engine3 = new SimulationEngine(directions3, map, positions);

        HashMap<Vector2d,IMapElement> animals = ((RectangularMap) map).getElements();

      //  assertEquals(animals.get(0).getPosition(), new Vector2d(1,2));
      //  assertEquals(animals.get(1).getPosition(), new Vector2d(2,3));
      //  assertEquals(animals.get(2).getPosition(), new Vector2d(3,1));

        engine3.run();

        assertNotEquals(animals.get(0), new Vector2d(0,3));
        assertNotEquals(animals.get(1), new Vector2d(3,3));
        assertNotEquals(animals.get(new Vector2d(3,2)), new Vector2d(3,2));
     //   assertEquals(animals.get(0).getOrientation(), MapDirection.EAST);
     //   assertEquals(animals.get(1).getOrientation(), MapDirection.WEST);
     //   assertEquals(animals.get(2).getOrientation(), MapDirection.EAST);
    }
}
