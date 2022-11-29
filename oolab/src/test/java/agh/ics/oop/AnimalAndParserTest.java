package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalAndParserTest {

    @Test
    void ParserTest() {
        String[] first = {"b", "f", "l", "r"};
        String[] second = {"backward", "B", "forward"};
        String[] third = {"c", "left", "right", "d", "f", "for"};
        OptionsParser tab = new OptionsParser();
        assertArrayEquals(tab.parse(first), new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT});
        assertArrayEquals(tab.parse(second), new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.FORWARD});
        assertArrayEquals(tab.parse(third), new MoveDirection[]{MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD});
    }

    @Test
    void AnimalTest() {
        String[] args = {"f", "r", "f", "f", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(2, 3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Map<Vector2d,IMapElement> elements = map.getElements();

        assertTrue(elements.containsKey(new Vector2d(3,3)));
        assertFalse(elements.containsValue(new Animal(map,new Vector2d(1,4))));
        assertTrue(elements.containsKey(new Vector2d(1,4)));
    }
}
