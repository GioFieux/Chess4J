
public class Position {
	
	private byte[][] pos = {
		{1,2,3,4,5,3,2,1},
		{6,6,6,6,6,6,6,6},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{7,7,7,7,7,7,7,7},
		{8,9,10,11,12,10,9,8}
	};
	
	private boolean whiteCastle;
	private boolean blackCastle;
	private boolean whiteCastleLong;
	private boolean blackCastleLong;
	private boolean turn;
	private Coordinate enPassant;
	
	public Position() {
		this.blackCastle = true;
		this.blackCastleLong = true;
		this.turn = true;
		this.whiteCastle = true;
		this.whiteCastleLong = true;
		this.enPassant = new Coordinate((byte)0,(byte)0);
	}
	
	public boolean getWhiteCastle() {
		return this.whiteCastle;
	}
	
	public void setWhiteCastle(boolean b) {
		this.whiteCastle = b;
	}
	
	public boolean getBlackCastle() {
		return this.blackCastle;
	}
	
	public void setBlackCastle(boolean b) {
		this.blackCastle = b;
	}
	
	public boolean getWhiteCastleLong() {
		return this.whiteCastleLong;
	}
	
	public void setWhiteCastleLong(boolean b) {
		this.whiteCastleLong = b;
	}
	
	public boolean getBlackCastleLong() {
		return this.blackCastleLong;
	}
	
	public void setBlackCastleLong(boolean b) {
		this.blackCastleLong = b;
	}
	
	public boolean getTurn() {
		return this.turn;
	}
	
	public void setTurn(boolean b) {
		this.turn = b;
	}
	
	public byte[][] getPos() {
		return this.pos;
	}
	
	public void setPos(byte[][] tab) {
		this.pos = tab;
	}
	
	public byte getPosCase(Coordinate c) {
		return this.pos[c.getRow()][c.getCol()];
	}
	
	public void setPosCase(Coordinate c, byte b) {
		this.pos[c.getRow()][c.getCol()] = b;
	}

	public Coordinate getEnPassant() {
		return enPassant;
	}

	public void setEnPassant(Coordinate enPassant) {
		this.enPassant = enPassant;
	}
	
	public void playMove(Coordinate c1, Coordinate c2, Game g) {
		this.turn = !(this.turn);
	}
	
	private void pseudoPlayMove(Coordinate c1, Coordinate c2) {
		
	}
	
	public byte[][] caseAccess(Coordinate c) {
		return null;
	}
	
	public void movePiece(Coordinate c1, Coordinate c2) {
		byte piece = this.getPosCase(c1);
		this.setPosCase(c1, (byte)0);
		this.setPosCase(c2, piece);
	}
	
	public byte testAdd(Position p, Coordinate c1, Coordinate c2, boolean b) {
		return 0;
	}
	
	public String toString() {
		String chessboard = "";
		for (byte i=0; i<8; i++) {
	        for (byte k=0; k<8; k++) {
	            chessboard = chessboard + "+---";
	        }
	        chessboard = chessboard + "+";
	        chessboard = chessboard + "\n";
	        for (byte j=0; j<8; j++) {
	        	switch (this.getPosCase(new Coordinate(i,j))) {
	        	case 0:
	        		chessboard = chessboard + "|   ";
	        		break;
	        	case 1:
	        		chessboard = chessboard + "| \u265C ";
	        		break;
	        	case 2:
	        		chessboard = chessboard + "| \u265E ";
	        		break;
	        	case 3:
	        		chessboard = chessboard + "| \u265D ";
	        		break;
	        	case 4:
	        		chessboard = chessboard + "| \u265B ";
	        		break;
	        	case 5:
	        		chessboard = chessboard + "| \u265A ";
	        		break;
	        	case 6:
	        		chessboard = chessboard + "| \u265F ";
	        		break;
	        	case 7:
	        		chessboard = chessboard + "| \u2659 ";
	        		break;
	        	case 8:
	        		chessboard = chessboard + "| \u2656 ";
	        		break;
	        	case 9:
	        		chessboard = chessboard + "| \u2658 ";
	        		break;
	        	case 10:
	        		chessboard = chessboard + "| \u2657 ";
	        		break;
	        	case 11:
	        		chessboard = chessboard + "| \u2655 ";
	        		break;
	        	case 12:
	        		chessboard = chessboard + "| \u2654 ";
	        		break;
	        	}
	        	
	        	/*if (this.getPosCase(new Coordinate(i,j)) < 10) {
	        		chessboard = chessboard +"| " + this.getPosCase(new Coordinate(i,j)) + " ";
	        	} else {
	        		chessboard = chessboard +"| " + this.getPosCase(new Coordinate(i,j));
	        	}*/
	        }
	        chessboard = chessboard + "|\n";
	    }
	    for (int k=0; k<8; k++) {
	    	chessboard = chessboard + "+---";
	    }
	    chessboard = chessboard + "+\n";
	    chessboard = chessboard + "\n";
	    chessboard = chessboard + "whiteCastle     : " + this.getWhiteCastle() + "\n";
	    chessboard = chessboard + "blackCastle     : " + this.getBlackCastle() + "\n";
	    chessboard = chessboard + "whiteCastleLong : " + this.getWhiteCastleLong() + "\n";
	    chessboard = chessboard + "blackCastleLong : " + this.getBlackCastleLong() + "\n";
	    chessboard = chessboard + "turn            : " + this.getTurn() + "\n";
	    chessboard = chessboard + "enPassant       : " + this.getEnPassant() + "\n";
	    return chessboard;
	}
}
