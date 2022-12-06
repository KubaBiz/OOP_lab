package agh.ics.oop;

import java.util.ArrayList;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap{
    private final int n;
    private final int zakres;
    private int count = 0;

    public GrassField(int param){
        n = Math.max(param, 0);
        zakres=(int) sqrt(n*10);
        right_corner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        left_corner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        max_position=new Vector2d(0,0);
        min_position=new Vector2d(0,0);
        placeGrass();
    }

    public Vector2d getRandomVector(int nka){
        int randomX = (int)(random() * (nka+1));
        int randomY = (int)(random() * (nka+1));
        return new Vector2d(randomX, randomY);
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
        while (count<n) {
            if (!canplaceGrass()) {
                return false;
            } else {
                while (true) {
                    Vector2d zmienna = getRandomVector(zakres);
                    if (objectAt(zmienna) == null) {
                        elements.put(zmienna, new Grass(zmienna));
                        mapBound.addElementToMap(zmienna);
                        count+=1;
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
        if (super.canMoveTo(position)){
            return true;
        }
        if (objectAt(position) instanceof Grass){
            elements.remove(position);
            count-=1;
            return true;
        }
        return false;
    }
    @Override
    public boolean place(Animal animal){
        if (super.place(animal)){
            return true;
        }
        if (objectAt(animal.getPosition()) instanceof Grass){
            elements.remove(animal.getPosition());
            count-=1;
            elements.put(animal.getPosition(), animal);
            animal.addObserver(this);;
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
        return null;
    }
    @Override
    public String toString(){
        min_position=mapBound.lowerLeftCheck();
        max_position=mapBound.upperRightCheck();
        return super.toString();
    }
}

//   private Vector2d minimal(){
//       Vector2d minimum=new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
//       for (IMapElement element: elements.values()){
//           minimum=new Vector2d(min(minimum.x, element.getPosition().x), min(minimum.y, element.getPosition().y));
//       }
//       if (elements.isEmpty()){
//           return new Vector2d(0,0);
//       }
//       return minimum;
//   }
//   private Vector2d maximal(){
//       Vector2d maksimum=new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
//       for (IMapElement element: elements.values()){
//           maksimum=new Vector2d(max(maksimum.x, element.getPosition().x), max(maksimum.y, element.getPosition().y));
//       }
//       if (elements.isEmpty()){ return new Vector2d(0,0); }
//       return maksimum;
//   }
