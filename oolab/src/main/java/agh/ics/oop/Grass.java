package agh.ics.oop;

public class Grass extends AbstractWorldElement{
    public Grass(Vector2d param){
        position = param;
    }

    @Override
    public String toString(){
        return "*";
    }
}
