package cruz;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        symbol='r';
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if(movement.direction()!=Direction.HORIZONTAL
        && movement.direction()!=Direction.VERTICAL){
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
            else{
                increment=movement.getHorizontalShift()>=0?1:-1;
                coordinate=new Coordinate(movement.getInitial().getRow(),movement.getInitial().getColumn()+increment);
                while(!coordinate.equals(movement.getEnding())){
                    coordinates.add(coordinate);
                    coordinate=new Coordinate(coordinate.getRow(),coordinate.getColumn()+increment);
                }
            }
        }
        return coordinates;
    } // CoordinatesInTheMiddle
}
