package cruz;

public class Movement {
    private Coordinate initial;
    private Coordinate ending;

    public Movement(Coordinate initial, Coordinate ending){
        this.initial=initial;
        this.ending=ending;
    }

    public int getHorizontalShift() {
        return ending.getColumn()-initial.getColumn();
    }

    public int getVerticalShift() {
        return ending.getRow()-initial.getRow();
    }

    public Direction direction(){
        return this.initial.direction(this.ending);
    }

    public Coordinate getInitial(){
        return initial;
    }

    public Coordinate getEnding(){
        return ending;
    }

}
