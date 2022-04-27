
public class Coordinate {
	private byte row;
	private byte col;
	
	public Coordinate(byte x, byte y) {
		this.row=x;
		this.col=y;
	}
	
	public byte getRow() {
		return this.row;
	}
	
	public byte getCol() {
		return this.col;
	}
	
	public void setRow(byte r) {
		this.row = r;
	}
	
	public void setCol(byte c) {
		this.col = c;
	}
	
	public String toString() {
		return "Row : " + this.getRow() + " | Col : " + this.getCol();
	}
}
