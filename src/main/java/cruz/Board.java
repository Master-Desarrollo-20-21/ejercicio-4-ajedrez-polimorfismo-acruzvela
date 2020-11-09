package cruz;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private HashMap<Coordinate, Piece> pieces;
    private boolean stop=false;

    public Board(){
        this.pieces=new HashMap<Coordinate, Piece>();
        this.Init();
    }

    private void Init(){
        pieces.put(new Coordinate(0,0),new Rook(Color.BLACK));
        pieces.put(new Coordinate(0,1),new Knight(Color.BLACK));
        pieces.put(new Coordinate(0,2),new Bishop(Color.BLACK));
        pieces.put(new Coordinate(0,3),new Queen(Color.BLACK));
        pieces.put(new Coordinate(0,4),new King(Color.BLACK));
        pieces.put(new Coordinate(0,5),new Bishop(Color.BLACK));
        pieces.put(new Coordinate(0,6),new Knight(Color.BLACK));
        pieces.put(new Coordinate(0,7),new Rook(Color.BLACK));
        pieces.put(new Coordinate(1,0),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,1),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,2),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,3),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,4),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,5),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,6),new Pawn(Color.BLACK));
        pieces.put(new Coordinate(1,7),new Pawn(Color.BLACK));

        pieces.put(new Coordinate(7,0),new Rook(Color.WHITE));
        pieces.put(new Coordinate(7,1),new Knight(Color.WHITE));
        pieces.put(new Coordinate(7,2),new Bishop(Color.WHITE));
        pieces.put(new Coordinate(7,3),new Queen(Color.WHITE));
        pieces.put(new Coordinate(7,4),new King(Color.WHITE));
        pieces.put(new Coordinate(7,5),new Bishop(Color.WHITE));
        pieces.put(new Coordinate(7,6),new Knight(Color.WHITE));
        pieces.put(new Coordinate(7,7),new Rook(Color.WHITE));
        pieces.put(new Coordinate(6,0),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,1),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,2),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,3),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,4),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,5),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,6),new Pawn(Color.WHITE));
        pieces.put(new Coordinate(6,7),new Pawn(Color.WHITE));

    }

    private int inputElement(String element) {
		Console console=new Console();
        int input;
        boolean right;
		do {
            right=true;
            input=console.inInt("Introduce " + element);
            if (input<0 || input >=Coordinate.DIMENSION){
                right=false;
                console.outln("value out of bounds");
            }
		}while(!right);
		return input;
    } // inputElement

    public boolean isEmpty(Coordinate coordinate){
        return !pieces.containsKey(coordinate);
    }

    public Color whatColor(Coordinate coordinate){
        if (!isEmpty(coordinate)){
            return pieces.get(coordinate).color;
        }
        return null;
    }

    public Coordinate inputCoordinate(){
        int row= inputElement("row");
        int column=inputElement("column");
        return new Coordinate(row,column);
    }

    public Coordinate inputInitial(Color color){
        Console console=new Console();
        console.outln("Introduce initial coordinate:");
        Coordinate initial;
        boolean right;
        do{
            right=true;
            initial=this.inputCoordinate();
            if(!isInitialOk(initial, color)){
                console.outln("Introduce a coordinate with a "+color+" piece");
                right=false;
            }
        }while(!right);
        return initial;
    }
    
    private boolean isInitialOk(Coordinate coordinate, Color color) {
        if(this.isEmpty(coordinate)){
            return false;
		}
		if(this.getPieces().get(coordinate).color!=color){
			return false;
		}
        return true;
    }

    public Coordinate inputEnding(Coordinate initial){
        Console console=new Console();
        console.outln("Introduce final coordinate:");
        Coordinate ending;
        boolean right;
        do{
            right=true;
            ending=this.inputCoordinate();
            if(!isEndingOk(initial, ending)){
                console.outln("Illegal movement, introduce a legal one");
                right=false;
            }
            else if(!this.isEmpty(ending)&&this.getPieces().get(ending).isAKing()){
                stop=true;
            }
        }while(!right);
        return ending;
    }
    
    private boolean isEndingOk(Coordinate initial, Coordinate ending) {
        Movement movement=new Movement(initial,ending);
        if(!this.getPieces().get(initial).isAllowed(movement)){
            return false;
        }

        if(!this.isEmpty(ending) && this.getPieces().get(ending).color==
        this.getPieces().get(initial).color){
			return false;
        }
        
        if(!this.isEmpty(getPieces().get(initial).CoordinatesInTheMiddle(movement))){
            return false;
        }

        return true;
    }

    public boolean isEmpty(ArrayList<Coordinate> coordinates){
        for (Coordinate coordinate : coordinates){
            if(pieces.containsKey(coordinate)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String out="";
        Coordinate coordinate=new Coordinate();
        for (int i=0;i<Coordinate.DIMENSION;i++){
            for (int j=0;j<Coordinate.DIMENSION;j++){
                coordinate.setCoordinates(i, j);
                out+=pieces.containsKey(coordinate)?pieces.get(coordinate).toString()+" ":". ";
            }
            out+="\n";
        }

        return out;
    } // toString

    HashMap<Coordinate, Piece> getPieces(){
        return pieces;
    }

    public boolean isAllowed(Movement movement){
        return false;
    }

    public boolean getStop(){
        return stop;
    }

}
