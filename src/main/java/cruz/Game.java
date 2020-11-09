package cruz;

import java.util.HashMap;

public class Game {
    private Board board;
    
    private HashMap<Color, Player> players;
    
    private Turn turn;
    
    private static final int NUM_PLAYERS = 2;

    public Game(){
        board = new Board();
        players = new HashMap<Color, Player>();
        for(int i=0; i<Game.NUM_PLAYERS; i++){
            players.put(Color.values()[i],new Player(Color.values()[i]));
        }
        turn = new Turn();
    }

    public void play(){
        Console console=new Console();
        do {
            console.outln(board.toString());
            players.get(turn.take()).move(board);
            turn.change();
        } while(!board.getStop());
        console.outln(board.toString());
        console.outln("The "+players.get(turn.notTake()).getColor() +" player won");
    }
}
