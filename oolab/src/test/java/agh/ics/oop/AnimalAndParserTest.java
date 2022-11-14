package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalAndParserTest {

    @Test
    void ParserTest(){
        String[] first = {"b", "f", "l", "r"};
        String[] second = {"backward", "B", "forward"};
        String[] third = {"c", "left", "right", "d","f", "for"};
        OptionsParser tab = new OptionsParser();
        assertArrayEquals(tab.parse(first),new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT });
        assertArrayEquals(tab.parse(second),new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.FORWARD});
        assertArrayEquals(tab.parse(third),new MoveDirection[] {MoveDirection.LEFT, MoveDirection.RIGHT,MoveDirection.FORWARD});
    }

  //  @Test
  //  void SmallAnimalTest(){
  //      Animal krowa = new Animal();
  //      assertEquals(krowa.toString(),"(2,2) Północ");
  //      String[] first = {"l", "l", "l", "r"};
  //      OptionsParser tab = new OptionsParser();
  //      for(MoveDirection arg: tab.parse(first)){
  //          krowa.move(arg);
  //      }
  //      assertEquals(krowa.toString(),"(2,2) Południe");
  //  }

  //  @Test
  //  void BigAnimalTest(){
  //      Animal krowa = new Animal();
  //      String[] first = {"f", "l", "f", "f", "f", "f", "l", "f", "b", "b", "b", "b", "r"};
  //      OptionsParser tab = new OptionsParser();
  //      for(MoveDirection arg: tab.parse(first)){
  //          krowa.move(arg);
  //      }
  //      assertEquals(krowa.toString(),"(0,4) Zachód");
  //  }
}
