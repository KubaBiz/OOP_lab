package agh.ics.oop;

public class World {
    public static void change(String[] tab, Direction[] kierunki){
        int size = tab.length;
        for (int i = 0;i<size;i++) {
            switch (tab[i]) {
                case "f" -> kierunki[i] = Direction.FORWARD;
                case "b" -> kierunki[i] = Direction.BACKWARD;
                case "r" -> kierunki[i] = Direction.RIGHT;
                case "l" -> kierunki[i] = Direction.LEFT;
                default -> kierunki[i] = Direction.UNKNOWN;
            }
        }
    }
    public static void run(Direction[] tab){
        int size = tab.length;
        for (int i = 0;i<size;i++) {
            String message = switch (tab[i]) {
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tyłu";
                case LEFT -> "Skręca w lewo";
                case RIGHT -> "Skręca w prawo";
                case UNKNOWN -> "Nieznana komenda";
            };
            if (i < size - 1) {
                System.out.println(message + ", ");
            } else {
                System.out.println(message);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("System START");
        Direction[] kierunki = new Direction[args.length];
        change(args, kierunki);
        run(kierunki);
        System.out.print("System STOP");
    }
}
