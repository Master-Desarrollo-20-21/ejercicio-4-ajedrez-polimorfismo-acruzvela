package cruz;

public class Turn {
    private Color color;
	
	public Turn() {
		this.color=Color.WHITE;
	}
	
    public Color take() {
        return this.color;
    }
    
    public Color notTake() {
    	return Color.values()[(this.color.getValue() +1) % 2];
    }
    
    public void change() {
    	color = this.notTake();
    }
}
