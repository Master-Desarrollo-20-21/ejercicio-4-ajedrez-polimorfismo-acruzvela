package cruz;

public enum Color {
    WHITE(0),
    BLACK(1);

    private int value;

    private Color(int value){
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }
    
    public void setValue(int value) {
    	this.value=value;
    }
}
