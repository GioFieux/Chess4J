public enum Piece {
	BLACKKING(1, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	BLACKQUEEN(7, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	BLACKBISHOP(7, new byte[][] { {1,1},{1,-1},{-1,1},{-1,-1} }), 
	BLACKKNIGHT(1, new byte[][] { {2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1} }), 
	BLACKROOK(7, new byte[][] { {1,0},{0,1},{0,-1},{-1,0} }), 
	BLACKPAWN(0, new byte[][] { {} } ), 
	WHITEKING(1, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	WHITEQUEEN(7, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	WHITEBISHOP(7, new byte[][] { {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1} }), 
	WHITEKNIGHT(1, new byte[][] { {2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1} }), 
	WHITEROOK(7, new byte[][] { {1,0},{0,1},{0,-1},{-1,0} }), 
	WHITEPAWN(0, new byte[][] { {} });
	
	private final int limit;
	private final byte[][] direction;
	
	private Piece(int l, byte[][] dir) {
		this.limit = l;
		this.direction = dir;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public byte[][] getDirection() {
		return this.direction;
	}
}
