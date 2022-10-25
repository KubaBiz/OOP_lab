package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        Integer truelength = 0;
        for(String arg: args){
            switch(arg){
                case "f" -> truelength +=1;
                case "forward" -> truelength +=1;
                case "b" -> truelength +=1;
                case "backward" -> truelength +=1;
                case "r" -> truelength +=1;
                case "right" -> truelength +=1;
                case "l" -> truelength +=1;
                case "left" -> truelength +=1;
            }
        }
        MoveDirection[] tablica = new MoveDirection[truelength];
        Integer i = 0;
        for(String arg: args) {
            switch (arg) {
                case "f" -> {
                    tablica[i] = MoveDirection.FORWARD;
                    i += 1;
                }
                case "forward" -> {
                    tablica[i] = MoveDirection.FORWARD;
                    i += 1;
                }
                case "b" -> {
                    tablica[i] = MoveDirection.BACKWARD;
                    i += 1;
                }
                case "backward" -> {
                    tablica[i] = MoveDirection.BACKWARD;
                    i += 1;
                }
                case "r" -> {
                    tablica[i] = MoveDirection.RIGHT;
                    i += 1;
                }
                case "right" -> {
                    tablica[i] = MoveDirection.RIGHT;
                    i += 1;
                }
                case "l" -> {
                    tablica[i] = MoveDirection.LEFT;
                    i += 1;
                }
                case "left" -> {
                    tablica[i] = MoveDirection.LEFT;
                    i += 1;
                }
            }
        }
        return tablica;
    }
}
