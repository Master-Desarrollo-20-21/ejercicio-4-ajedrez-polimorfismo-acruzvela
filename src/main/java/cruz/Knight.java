package cruz;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
        symbol = 'k';
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if (movement.direction() != Direction.KNIGHT) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement) {
        return new ArrayList<Coordinate>();
    }
    
}
