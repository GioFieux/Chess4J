import java.util.Timer;

public class Game {
	private String PGN;
	private Timer timeP1;
	private Timer timeP2;
	private boolean displayMode;
	
	public Game() {
		
	}
	
	public String getPGN() {
		return this.PGN;
	}
	
	public void setPGN(String s) {
		this.PGN = s;
	}
	
	public boolean getDisplayMode() {
		return this.displayMode;
	}
	
	public void setDisplayMode(boolean b) {
		this.displayMode = b;
	}
}
