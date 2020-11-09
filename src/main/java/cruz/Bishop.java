package cruz;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
        symbol = 'b';
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if (movement.direction() != Direction.DIAGONAL) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement) {
        ArrayList<Coordinate> coordinates=new ArrayList<Coordinate>();
        if(this.isAllowed(movement)){
            Coordinate coordinate;
            int incrementVertical=movement.getVerticalShift()>=0?1:-1;
            int incrementHorizontal=movement.getHorizontalShift()>=0?1:-1;
            coordinate=new Coordinate(movement.getInitial().getRow()+incrementVertical,
            movement.getInitial().getColumn()+incrementHorizontal);
            while(!coordinate.equals(movement.getEnding())){
                coordinates.add(coordinate);
                coordinate=new Coordinate(coordinate.getRow()+incrementVertical,
                coordinate.getColumn()+incrementHorizontal);
            }
        }
        return coordinates;
    }
    
}
