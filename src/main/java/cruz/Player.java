package cruz;

public class Player {
    private Color color;

	public Player(Color color) {
		this.color = color;
	}

	public void move(Board board){
		Coordinate initial=board.inputInitial(this.color);
		Coordinate ending=board.inputEnding(initial);
		board.getPieces().put(ending,board.getPieces().get(initial));
		board.getPieces().remove(initial);
	}

	public Color getColor(){
		return this.color;
	}
}
