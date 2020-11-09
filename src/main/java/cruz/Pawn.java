package cruz;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
        symbol = 'p';
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if (movement.direction() != Direction.VERTICAL&&movement.direction() != Direction.DIAGONAL){
            return false;
        }

        if (movement.direction() == Direction.VERTICAL){
            if (this.color == Color.BLACK && movement.getInitial().getRow()==1
                    && (movement.getVerticalShift() <= 0 || movement.getVerticalShift() > 2)
                || this.color == Color.WHITE && movement.getInitial().getRow()==6
                    && (movement.getVerticalShift() < -2 || movement.getVerticalShift() >= 0)) {
                return false;
            }
            if (this.color == Color.BLACK && movement.getInitial().getRow()!=1
                    && (movement.getVerticalShift() <= 0 || movement.getVerticalShift() > 1)
                || this.color == Color.WHITE&& movement.getInitial().getRow()!=6
                    && (movement.getVerticalShift() < -1 || movement.getVerticalShift() >= 0)) {
                return false;
            }
        }
        else{
            if (this.color == Color.BLACK 
                && (movement.getVerticalShift() <= 0 || movement.getVerticalShift() > 1)
                && (movement.getHorizontalShift() != -1 && movement.getHorizontalShift() != 1)
            || this.color == Color.WHITE 
                && (movement.getVerticalShift() < -1 || movement.getVerticalShift() >= 0)
                && (movement.getHorizontalShift() != -1 && movement.getHorizontalShift() != 1)){
            return false;
            }
        }
        return true;
    } // isAllowed

    @Override
    public ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement) {
        ArrayList<Coordinate> coordinates=new ArrayList<Coordinate>();
        if(this.isAllowed(movement)){
            Coordinate coordinate;
            int increment=movement.getVerticalShift()>=0?1:-1;
            coordinate=new Coordinate(movement.getInitial().getRow()+increment,movement.getInitial().getColumn());
            while(!coordinate.equals(movement.getEnding())){
                coordinates.add(coordinate);
                coordinate=new Coordinate(coordinate.getRow()+increment,coordinate.getColumn());
            }
        }
        return coordinates;
    }
    
}
