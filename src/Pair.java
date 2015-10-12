
public class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getFirst() {
		return x;

	}

	int getSecond() {
		return y;
	}
	
	@Override
	public String toString() {
		return new String("first : ["+x+"], Second : ["+y+"]");
		
	}
	

}