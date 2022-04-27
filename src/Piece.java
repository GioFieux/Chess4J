public enum Piece {
	BLACKKING(12, 1, false, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	BLACKQUEEN(11, 7, false, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	BLACKBISHOP(10, 7, false, new byte[][] { {1,1},{1,-1},{-1,1},{-1,-1} }), 
	BLACKKNIGHT(9, 1, false, new byte[][] { {2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1} }), 
	BLACKROOK(8, 7, false, new byte[][] { {1,0},{0,1},{0,-1},{-1,0} }), 
	BLACKPAWN(7, 0, false, new byte[][] { {1,0},{2,0},{1,1},{1,-1} } ),
	
	WHITEKING(5, 1, true, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	WHITEQUEEN(4, 7, true, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	WHITEBISHOP(3, 7, true, new byte[][] { {1,1},{1,-1},{-1,1},{-1,-1} }), 
	WHITEKNIGHT(2, 1, true, new byte[][] { {2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1} }), 
	WHITEROOK(1, 7, true, new byte[][] { {1,0},{0,1},{0,-1},{-1,0} }), 
	WHITEPAWN(6, 0, true, new byte[][] { {-1,0},{-2,0},{-1,1},{-1,-1} });
	
	private final int id;
	private final int limit;
	private final boolean team;
	private final byte[][] direction;
	
	private Piece(int i, int l, boolean t, byte[][] dir) {
		this.limit = l;
		this.direction = dir;
		this.id=i;
		this.team=t;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public byte[][] getDirection() {
		return this.direction;
	}
	
	public byte getId() {
		return (byte) this.id;
	}
	
	public boolean getTeam() {
		return this.team;
	}	
}
