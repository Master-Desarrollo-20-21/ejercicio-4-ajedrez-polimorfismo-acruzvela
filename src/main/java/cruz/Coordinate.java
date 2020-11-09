package cruz;

public class Coordinate {
    private int row;
	
	private int column;
	
	public static final int DIMENSION = 8;
	
	private static final ClosedInterval LIMITS = new ClosedInterval(0, Coordinate.DIMENSION-1);

	public Coordinate(){	
	}
	
	public Coordinate(int row, int column){	
		assert LIMITS.includes(row);
		assert LIMITS.includes(column);
		this.row = row;
		this.column = column;
	}
	
	public Direction direction(Coordinate coordinate){
		assert coordinate != null;
		if (this.inRow(coordinate)){
			return Direction.HORIZONTAL;
		}
		if (this.inColumn(coordinate)){
			return Direction.VERTICAL;
		}
		if (this.inDiagonal(coordinate)){
			return Direction.DIAGONAL;
		}
		if (this.inKnightJump(coordinate)){
			return Direction.KNIGHT;
		}
		
		return Direction.NON_EXISTENT;
	}
	
	private boolean inRow(Coordinate coordinate){
		return row == coordinate.row;
	}
	
	private boolean inColumn(Coordinate coordinate){
		return column == coordinate.column;
	}
	
	private boolean inDiagonal(Coordinate coordinate){
        return row + column == coordinate.row+coordinate.column
        || row - column == coordinate.row-coordinate.column;
	}

	private boolean inKnightJump(Coordinate coordinate){
		Movement movement=new Movement(this,coordinate);
		return Math.abs(movement.getHorizontalShift())==2 && Math.abs(movement.getVerticalShift())==1 
		|| Math.abs(movement.getHorizontalShift())==1 && Math.abs(movement.getVerticalShift())==2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public void setCoordinates(int row, int column) {
		this.row = row;
		this.column=column;
	}

	@Override
	public String toString(){
		return "["+this.row+", "+this.column+"]";

	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

}
