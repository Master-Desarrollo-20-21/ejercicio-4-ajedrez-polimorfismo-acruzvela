package cruz;

import java.util.ArrayList;

public abstract class Piece {
    protected char symbol;
    protected Color color;

    public Piece(Color color){
        this.color=color;
    }

    public boolean isAKing(){
        return false;
    }

    public abstract boolean isAllowed(Movement movement);
    public abstract ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement);

    @Override
    public String toString(){
        return (this.color==Color.BLACK?Character.toString(this.symbol).toUpperCase():
        Character.toString(this.symbol));
    }
}
