package cruz;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
        symbol = 'q';
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if (movement.direction() != Direction.HORIZONTAL && movement.direction() != Direction.VERTICAL
                && movement.direction() != Direction.DIAGONAL) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement) {
        ArrayList<Coordinate> coordinates=new ArrayList<Coordinate>();
        if(this.isAllowed(movement)){
            int increment;
            Coordinate coordinate;
            if(movement.direction()==Direction.VERTICAL){
                increment=movement.getVerticalShift()>=0?1:-1;
                coordinate=new Coordinate(movement.getInitial().getRow()+increment,movement.getInitial().getColumn());
                while(!coordinate.equals(movement.getEnding())){
                    coordinates.add(coordinate);
                    coordinate=new Coordinate(coordinate.getRow()+increment,coordinate.getColumn());
                }
            }
            else if(movement.direction()==Direction.HORIZONTAL){
                increment=movement.getHorizontalShift()>=0?1:-1;
                coordinate=new Coordinate(movement.getInitial().getRow(),movement.getInitial().getColumn()+increment);
                while(!coordinate.equals(movement.getEnding())){
                    coordinates.add(coordinate);
                    coordinate=new Coordinate(coordinate.getRow(),coordinate.getColumn()+increment);
                }
            }
            else{
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
        }
        return coordinates;
    } // CoordinatesInTheMiddle
}
