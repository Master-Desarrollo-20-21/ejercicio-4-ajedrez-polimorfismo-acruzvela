package cruz;

/**
 * Hello world!
 */
public final class Chess {
    private Chess() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Console console=new Console();
        String answer;
        do{
            new Game().play();
            do{
                answer=console.inString("¿Do you want to play another game y/n?");
            }while(!answer.toUpperCase().equals("Y")&&!answer.toUpperCase().equals("N"));
            
        }while(answer.toUpperCase().equals("Y"));
    }

}
