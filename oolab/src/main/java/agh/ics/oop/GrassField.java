package agh.ics.oop;

import java.util.ArrayList;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap{
    private final int n;
    private final int zakres;
    private ArrayList<Grass> grasses;

    public GrassField(int param){
        n=param;
        zakres=(int) sqrt(n*10);
        right_corner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        left_corner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        max_position=new Vector2d(zakres,zakres);
        min_position=new Vector2d(0,0);
        grasses= new ArrayList<>();
        animals= new ArrayList<>();
        placeGrass();
    }

    public Vector2d getRandomVector(int nka){
        int randomX = (int)(random() * (nka+1));
        int randomY = (int)(random() * (nka+1));
        return new Vector2d(randomX, randomY);
    }
    private Vector2d minimal(){
        Vector2d minimum=min_position;
        for (Animal animal: animals){
            minimum=new Vector2d(min(minimum.x, animal.getPosition().x), min(minimum.y, animal.getPosition().y));
        }
        min_position = minimum;
        return minimum;
    }
    private Vector2d maximal(){
        Vector2d maksimum=max_position;
        for (Animal animal: animals){
            maksimum=new Vector2d(max(maksimum.x,animal.getPosition().x), max(maksimum.y,animal.getPosition().y));
        }
        max_position = maksimum;
        return maksimum;
    }
    private boolean canplaceGrass(){
        for (int i=0; i<=zakres; i++){
            for (int j=0; j<=zakres; j++){
                if (objectAt(new Vector2d(i,j))==null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean placeGrass(){
        boolean flag = false;
        while (grasses.size()<n) {
            if (!canplaceGrass()) {
                return false;
            } else {
                while (true) {
                    Vector2d zmienna = getRandomVector(zakres);
                    if (objectAt(zmienna) == null) {
                        grasses.add(new Grass(zmienna));
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.follows(left_corner) && position.precedes(right_corner) && !this.isOccupied(position)){
            return true;
        }
        if (objectAt(position)instanceof Grass){
            grasses.remove(objectAt(position));
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal){
        if (canMoveTo(animal.getPosition()) && !isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        if (objectAt(animal.getPosition()) instanceof Grass){
            grasses.remove(objectAt(animal.getPosition()));
            animals.add(animal);
            placeGrass();
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        if (super.objectAt(position)!=null){
            return super.objectAt(position);
        }
        for (Grass grass: grasses){
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        min_position=minimal();
        max_position=maximal();
        return super.toString();
    }
}
