package agh.ics.oop;

public class World {
    public static void run(String[] tab){
        System.out.println("Zwierzak idzie do przodu");
        int size = tab.length;
        for (int i = 0;i<size-1;i++){
            System.out.print(tab[i]+", ");
        }
        System.out.println(tab[size-1]);

    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.print("system zakończył działanie");
    }
}
