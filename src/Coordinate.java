
public class Coordinate {
	private byte row;
	private byte col;
	
	//WARNING !!! Coordinate doesn't throw any kind if error ...
	public Coordinate(byte x, byte y) {
		this.row=x;
		this.col=y;
	}
	
	public Coordinate(String str){
		if(!(str.length()==2) ) {		}
		char col = str.charAt(0);
		char row = str.charAt(1);
		
		byte x=0;
		byte y=0;
		
		switch(row){
		case '0':
			x=0;
			break;
		case '1':
			x=1;
			break;
		case '2':
			x=2;
			break;
		case '3':
			x=3;
			break;
		case '4':
			x=4;
			break;
		case '5':
			x=5;
			break;
		case '6':
			x=6;
			break;
		case '7':
			x=7;
			break;
		}
		
		switch(col){
		case 'a':
			y=0;
			break;
		case 'b':
			y=1;
			break;
		case 'c':
			y=2;
			break;
		case 'd':
			y=3;
			break;
		case 'e':
			y=4;
			break;
		case 'f':
			y=5;
			break;
		case 'g':
			y=6;
			break;
		case 'h':
			y=7;
			break;
		}
		
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
	
	public boolean equals(Object o) {
		if(o instanceof Coordinate) {
			Coordinate c = (Coordinate) o;
			return(this.getCol()==c.getCol() && this.getRow()==c.getRow());
		}
		return false;
	}
}
