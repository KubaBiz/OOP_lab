package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) throws IllegalArgumentException{
        int truelength = 0;
        for(String arg: args){
            try {
                switch (arg) {
                    case "f" -> truelength += 1;
                    case "forward" -> truelength += 1;
                    case "b" -> truelength += 1;
                    case "backward" -> truelength += 1;
                    case "r" -> truelength += 1;
                    case "right" -> truelength += 1;
                    case "l" -> truelength += 1;
                    case "left" -> truelength += 1;
                    default -> throw new IllegalArgumentException();
                }
            } catch(IllegalArgumentException ex){
                throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        MoveDirection[] tablica = new MoveDirection[truelength];
        int i = 0;
        for(String arg: args) {
            switch (arg) {
                case "f", "forward" -> {
                    tablica[i] = MoveDirection.FORWARD;
                    i += 1;
                }
                case "b", "backward" -> {
                    tablica[i] = MoveDirection.BACKWARD;
                    i += 1;
                }
                case "r", "right" -> {
                    tablica[i] = MoveDirection.RIGHT;
                    i += 1;
                }
                case "l", "left" -> {
                    tablica[i] = MoveDirection.LEFT;
                    i += 1;
                }
            }
        }
        return tablica;
    }
}
