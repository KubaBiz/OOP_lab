package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, EAST, WEST;
    @Override
    public String toString(){
        return(switch(this){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        });
    }
    public MapDirection next(){
        return(switch(this){
            case EAST -> SOUTH;
            case WEST -> NORTH;
            case NORTH -> EAST;
            case SOUTH -> WEST;
        });
    }
    public MapDirection previous(){
        return(switch(this){
            case EAST -> NORTH;
            case WEST -> SOUTH;
            case NORTH -> WEST;
            case SOUTH -> EAST;
        });
    }
    public Vector2d toUnitVector(){
        return(new Vector2d(switch(this){
            case EAST -> 1;
            case WEST -> -1;
            case NORTH -> 0;
            case SOUTH -> 0;
        }, switch(this){
            case EAST -> 0;
            case WEST -> 0;
            case NORTH -> 1;
            case SOUTH -> -1;
        }));
    }

}