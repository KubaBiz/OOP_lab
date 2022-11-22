package agh.ics.oop;

public class Animal extends AbstractWorldElement{
    IWorldMap map;
    private MapDirection orientation;
    public Animal (IWorldMap mapa, Vector2d initialPosition){
        orientation = MapDirection.NORTH;
        map = mapa;
        position = initialPosition;
    }
    @Override
    public String toString(){ return orientation.toString(); }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) orientation = orientation.next();
        else if (direction == MoveDirection.LEFT) orientation = orientation.previous();
        else{
            int a = MoveDirection.FORWARD == direction ? 1 : -1;
            Vector2d tmp;
            if (a == 1){
                tmp = position.add(orientation.toUnitVector());
            }
            else {
                tmp = position.subtract(orientation.toUnitVector());
            }
            if (map.canMoveTo(tmp)){
                position=tmp;
            }
        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

}
