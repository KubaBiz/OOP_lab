package agh.ics.oop;

abstract class AbstractWorldElement implements IMapElement{
    public Vector2d position;
    public Vector2d getPosition(){
        return position;
    }

    public String getImage(){
        String result;
        switch(this.toString()){
            case ("N") -> result = "src/main/resources/up.png";
            case ("E") -> result = "src/main/resources/right.png";
            case ("S") -> result = "src/main/resources/down.png";
            case ("W") -> result = "src/main/resources/left.png";
            case ("*") -> result = "src/main/resources/grass.png";
            default -> result = null;
        }
        return result;
    }
}
