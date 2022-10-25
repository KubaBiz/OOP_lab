package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString(){
    return position.toString() +" "+ orientation;
    }
    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                switch(orientation){
                    case EAST:
                        if(position.x<4) {
                            position = position.add(orientation.toUnitVector());
                        }
                        break;
                    case WEST:
                        if(position.x>0) {
                            position = position.add(orientation.toUnitVector());
                        }
                        break;
                    case NORTH:
                        if (position.y<4) {
                            position = position.add(orientation.toUnitVector());
                        }
                        break;
                    case SOUTH:
                        if (position.y>0) {
                            position = position.add(orientation.toUnitVector());
                        }
                        break;
                }
                break;
            case BACKWARD:
                switch(orientation){
                    case EAST:
                        if(position.x>0) {
                            position = position.subtract(orientation.toUnitVector());
                        }
                        break;
                    case WEST:
                        if(position.x<4) {
                            position = position.subtract(orientation.toUnitVector());
                        }
                        break;
                    case NORTH:
                        if (position.y>0) {
                            position = position.subtract(orientation.toUnitVector());
                        }
                        break;
                    case SOUTH:
                        if (position.y<4) {
                            position = position.subtract(orientation.toUnitVector());
                        }
                        break;
                }
                break;
        }
    }
}
