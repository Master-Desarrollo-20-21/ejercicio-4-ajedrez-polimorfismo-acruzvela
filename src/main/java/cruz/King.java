package cruz;

import java.util.ArrayList;

public class King extends Piece {

    public King(Color color) {
        super(color);
        symbol = 'k';
    }

    @Override
    public boolean isAKing() {
        return true;
    }

    @Override
    public boolean isAllowed(Movement movement) {
        if (movement.direction() != Direction.HORIZONTAL && movement.direction() != Direction.VERTICAL
                && movement.direction() != Direction.DIAGONAL && Math.abs(movement.getHorizontalShift()) > 1
                && Math.abs(movement.getVerticalShift()) > 1 || Math.abs(movement.getHorizontalShift()) > 1
                || Math.abs(movement.getVerticalShift()) > 1) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Coordinate> CoordinatesInTheMiddle(Movement movement) {
        return new ArrayList<Coordinate>();
    }
}
