public class Position {
	
	private byte[][] pos = {
		{Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKROOK.getId()},
		{Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKPAWN.getId()},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId(),Piece.WHITEPAWN.getId()},
		{Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEROOK.getId()}
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
		this.turn = true; //whitePlayer turn
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
		byte[][] tmp = caseAccess(c1);

		if (tmp[c2.getRow()][c2.getCol()] > 0) {
			//pseudoPlayMove(c1,c2)
			movePiece(c1, c2); 	
			//UpdateTimePGN
			System.out.println("Move done");
			this.setTurn(!(this.getTurn()));
		} else { 
			throw new RuntimeException();
		}

       		System.out.println("tmp = "+Arrays.deepToString(tmp));
	}
	
	public void playMove(Coordinate c1, Coordinate c2, Game g, Piece p) {
		this.playMove(c1,c2,g);
		this.setPosCase(c2, p.getId());
		g.setPGN(g.getPGN() + " Promotion en : " + p.name());
	}
	
	private void pseudoPlayMove(Coordinate c1, Coordinate c2) {
		
	}
	
	public byte[][] caseAccess(Coordinate c) {
		
		int limit; //corresponds to the maximum advance of a piece in one direction
		int nbDirection; //corresponds to the numbers of the different possible directions per piece 
		
		byte[][] resultMatrix = new byte[8][8]; //corresponds to the matrix of accessible cases
		for(int i=0; i<8; i++) {
			for(int j=0;j<8;j++) {
				resultMatrix[i][j]=0;
			}
		} //resultMatrix initialized with 0
		
		Coordinate cTest = new Coordinate((byte)0, (byte)0);
		
		switch(this.getPosCase(c)) {
		
		case 0: //case empty case
			break;
			
		case 1: //case WHITEROOK
			if (this.getTurn()) { 								
				
				limit = Piece.WHITEROOK.getLimit();
				
				byte[][] direction = Piece.WHITEROOK.getDirection();
				nbDirection = Piece.WHITEROOK.getDirection().length;
				boolean team = Piece.WHITEROOK.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 2: //case WHITEKNIGHT
			
			if (this.getTurn()) { 								
				
				limit = Piece.WHITEKNIGHT.getLimit();
				
				byte[][] direction = Piece.WHITEKNIGHT.getDirection();
				nbDirection = Piece.WHITEKNIGHT.getDirection().length;
				boolean team = Piece.WHITEKNIGHT.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
		
		case 3: //case WHITEBISHOP
			
			if (this.getTurn()) { 								
				
				limit = Piece.WHITEBISHOP.getLimit();
				
				byte[][] direction = Piece.WHITEBISHOP.getDirection();
				nbDirection = Piece.WHITEBISHOP.getDirection().length;
				boolean team = Piece.WHITEBISHOP.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 4: //case WHITEQUEEN
			
			if (this.getTurn()) { 								
				
				limit = Piece.WHITEQUEEN.getLimit();
				
				byte[][] direction = Piece.WHITEQUEEN.getDirection();
				nbDirection = Piece.WHITEQUEEN.getDirection().length;
				boolean team = Piece.WHITEQUEEN.getTeam();
		
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 5: //case WHITEKING
			
			if (this.getTurn()) { 								
				
				limit = Piece.WHITEKING.getLimit();
				
				byte[][] direction = Piece.WHITEKING.getDirection();
				nbDirection = Piece.WHITEKING.getDirection().length;
				boolean team = Piece.WHITEKING.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
				
				if(! (this.isChecked()) ) {
					
					if (this.getWhiteCastle()) {
						if (this.isControlled()) {
							//en l'attente des defs cases d'Alexis
						}
					} else if (this.getWhiteCastleLong()) {
						if (this.isControlled()) {
							//en l'attente des defs cases d'Alexis
						}
					}
				}
			}
			break;
			
		case 6: //case WHITEPAWN
			
			if(this.getTurn()) {
				
				byte[] classicDirection = Piece.WHITEPAWN.getDirection()[0];
				byte[] twoCasesDirection = Piece.WHITEPAWN.getDirection()[1];
				byte[] iRight = Piece.WHITEPAWN.getDirection()[2];
				byte[] iLeft = Piece.WHITEPAWN.getDirection()[3];
				boolean team = Piece.WHITEPAWN.getTeam();
				
				resultMatrix=searchPawnCaseAccess(c, cTest, resultMatrix, classicDirection, twoCasesDirection, iRight, iLeft, team);
			}
			
			break;
			
		case 7: //case BLACKPAWN
			
			if(!(this.getTurn())) {
				
				byte[] classicDirection = Piece.BLACKPAWN.getDirection()[0];
				byte[] twoCasesDirection = Piece.BLACKPAWN.getDirection()[1];
				byte[] iRight = Piece.BLACKPAWN.getDirection()[2];
				byte[] iLeft = Piece.BLACKPAWN.getDirection()[3];
				boolean team = Piece.BLACKPAWN.getTeam();
				
				resultMatrix=searchPawnCaseAccess(c, cTest, resultMatrix, classicDirection, twoCasesDirection, iRight, iLeft, team);
			}
			
			break;
			
		case 8: //case BLACKROOK
			
			if (!(this.getTurn())) { 								
				
				limit = Piece.BLACKROOK.getLimit();
				
				byte[][] direction = Piece.BLACKROOK.getDirection();
				nbDirection = Piece.BLACKROOK.getDirection().length;
				boolean team = Piece.BLACKROOK.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 9: //case BLACKKNIGHT
			
			if (!(this.getTurn())) { 								
				
				limit = Piece.BLACKKNIGHT.getLimit();
				
				byte[][] direction = Piece.BLACKKNIGHT.getDirection();
				nbDirection = Piece.BLACKKNIGHT.getDirection().length;
				boolean team = Piece.BLACKKNIGHT.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
		
		case 10: //case BLACKBISHOP
			
			if (!(this.getTurn())) { 								
				
				limit = Piece.BLACKBISHOP.getLimit();
				
				byte[][] direction = Piece.BLACKBISHOP.getDirection();
				nbDirection = Piece.BLACKBISHOP.getDirection().length;
				boolean team = Piece.BLACKBISHOP.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 11: //case BLACKQUEEN
			
			if (!(this.getTurn())) { 								
				
				limit = Piece.BLACKQUEEN.getLimit();
				
				byte[][] direction = Piece.BLACKQUEEN.getDirection();
				nbDirection = Piece.BLACKQUEEN.getDirection().length;
				boolean team = Piece.BLACKQUEEN.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
			}
			break;
			
		case 12: //case BLACKKING
			
			if (!(this.getTurn())) { 								
				
				limit = Piece.BLACKKING.getLimit();
				
				byte[][] direction = Piece.BLACKKING.getDirection();
				nbDirection = Piece.BLACKKING.getDirection().length;
				boolean team = Piece.BLACKKING.getTeam();
				
				resultMatrix=searchCaseAccess(c,cTest,resultMatrix,limit,direction,nbDirection,team);
				
				if(! (this.isChecked()) ) {
					
					if (this.getBlackCastle()) {
						if (this.isControlled()) {
							//en l'attente des defs cases d'Alexis
						}
					} else if (this.getBlackCastleLong()) {
						if (this.isControlled()) {
							//en l'attente des defs cases d'Alexis
						}
					}
				}
			}
			break;
		}
		displayCaseAccess(resultMatrix);
		return resultMatrix;
	}
	
	private byte[][] searchCaseAccess(Coordinate c, Coordinate cTest, byte[][] resultMatrix, int limit, byte[][] direction, int nbDirection, boolean team) {
		
		for(int j=0;j<nbDirection;j++) {
			int step=0; 			  //corresponds to the advance of a piece in one direction at a certain time
			boolean keepgoing = true; //check if the next cases could be accessible
			byte[] currentDirection = direction[j];
			byte deltaX = currentDirection[0];
			byte deltaY = currentDirection[1];
			int y = c.getCol() + deltaY;
			int x = c.getRow() + deltaX;
			cTest.setCol((byte)y);
			cTest.setRow((byte)x);
			
			while(step<limit && keepgoing && isOnChessboard(cTest)) {
				
				x = x + deltaX;
				y = y + deltaY;
				
				cTest.setRow((byte)x);
				cTest.setCol((byte)y);
			
				switch(this.getPosCase(cTest)) {
				case 0:					 //empty case
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
					break;
				case 7,8,9,10,11,12:     
					if (team) { //enemy piece for white player
						resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
					} else { 	//allied piece for white player
						resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
					}
					keepgoing=false;
					break;
				case 1,2,3,4,5,6:		 
					if (team) { //allied piece for white player
						resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
					} else { 	//enemy piece for white player
						resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
					}
					keepgoing=false;
					break;
				}
				step++;
			}
		}
		return resultMatrix;
	}
	
	private byte[][] searchPawnCaseAccess(Coordinate c, Coordinate cTest, byte[][] resultMatrix, byte[] classicDirection, byte[] twoCasesDirection, byte[] iRight, byte[] iLeft, boolean team) {
	
		byte twoCasesRow;
		Coordinate cTest2;
		byte enPassantRow;
		
		if (team) {
			twoCasesRow=6;
			enPassantRow=3;
		} else {
			twoCasesRow=1;
			enPassantRow=4;
		}
		
		if (c.getRow()!=1 && c.getRow()!=6) { //case classic move
			
			int a = c.getRow() + classicDirection[0];
			int b = c.getCol() + classicDirection[1];
			
			cTest.setRow((byte)a);
			cTest.setCol((byte)b);
			
			if(this.getPosCase(cTest)==0) {			 //empty case
				resultMatrix[cTest.getRow()][cTest.getCol()]=1;//testAdd(this, c, cTest, false);
			} //there is no else because whatever it's a allied or enemy piece, the pawn cannot move forward
				// so resultMatrix in cTest stays to 0
				
		} else if (c.getRow()==twoCasesRow) {
			
			//case move 2 cases 
			int a = c.getRow() + twoCasesDirection[0];
			int b = c.getCol() + twoCasesDirection[1];
			
			if(team) {
				cTest2 = new Coordinate((byte)(a+1),(byte)b);
			} else {
				cTest2 = new Coordinate((byte)(a-1),(byte)b);
			}
			
			cTest.setCol((byte)b);
			cTest.setRow((byte)a);
			
			if(this.getPosCase(cTest2)==0) {
				resultMatrix[cTest2.getRow()][cTest2.getCol()]=testAdd(this, c, cTest2, false);
				//if (true) {//if(testAdd(this, c, cTest2, false)==1) {
					if(this.getPosCase(cTest)==0) {
						resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest2, false);
					}
				//}
			} //there is no else because whatever it's a allied or enemy piece, the pawn cannot move forward
			  // so resultMatrix in cTest stays to 0
		}
		
		//case pawn take
		
		int a = c.getRow() + iRight[0];
		int b = c.getCol() + iRight[1];
		
		cTest.setRow((byte)a);
		cTest.setCol((byte)b);
		
		Coordinate accessEnPassant = this.getEnPassant();
		
		if(isOnChessboard(cTest)) {
			switch(this.getPosCase(cTest)) {
			case 7,8,9,10,11,12:     
				if (team) { //enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
				} else { 	//allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
				}
				break;
			case 1,2,3,4,5,6:		 
				if (team) { //allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
				} else { 	//enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
				}
				break;
			}
			if(accessEnPassant.equals(cTest) && c.getRow()==enPassantRow) { //case prise en passant
				resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()]=testAdd(this,c,cTest,true);
			}
		}
		
		a = c.getRow() + iLeft[0];
		b = c.getCol() + iLeft[1];
		
		cTest.setRow((byte)a);
		cTest.setCol((byte)b);
		
		if(isOnChessboard(cTest)) {
			switch(this.getPosCase(cTest)) {
			case 7,8,9,10,11,12:     
				if (team) { //enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
				} else { 	//allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
				}
				break;
			case 1,2,3,4,5,6:		 
				if (team) { //allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, false);
				} else { 	//enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=testAdd(this, c, cTest, true);
				}
				break;
			}
			if(accessEnPassant.equals(cTest) && c.getRow()==enPassantRow) { //case prise en passant
				resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()]=testAdd(this,c,cTest,true);
			}
		}
		return resultMatrix;
	}
	
	private void displayCaseAccess(byte[][] resultMatrix) {
		String test="";
		for(int i=0; i<resultMatrix.length; i++) {
			for(int j=0;j<resultMatrix[i].length;j++) {
				test = test + resultMatrix[i][j] + " ";
			}
			test = test + "\n";
		}
		System.out.println(test);
	}
	
	private boolean isOnChessboard(Coordinate c) { //check if the case is on chessboard
		boolean onChessboard=true;
		byte a=c.getRow();
		byte b=c.getCol();
		if(a<(byte)8 && a>(byte)-1) {
			if(b<(byte)8 && b>(byte)-1) {
				onChessboard = true;
			} else { onChessboard = false; }
		} else { onChessboard = false; }
		
		return onChessboard;
	}
	
	public boolean isControlled(Coordinate c) {
		byte l=c.getRow();
		byte c1=c.getCol();
		Coordinate casetest;
		byte [][] directions;
		if (this.getTurn()==true){// Player with White Pieces
			directions=Piece.WHITEROOK.getDirection();
			for(byte [] direction : directions) {// rook direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				boolean keepgoing=true;
				while((keepgoing) && (isOnChessboard(casetest))) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case 0 :
								break;
							case Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKKING.getId(): 
								keepgoing=false;
								break;
							case Piece.BLACKROOK.getId(),Piece.BLACKQUEEN.getId():
								return true;
						}
					}
			}
			
			directions=Piece.WHITEBISHOP.getDirection();
			for(byte [] direction : directions) {// Bishop direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKKING.getId() :
								break;
							case Piece.BLACKQUEEN.getId(),Piece.BLACKBISHOP.getId():
								return true;
						}
					}
			}
			
			directions=Piece.WHITEKNIGHT.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId() :
								break;
							case Piece.BLACKKNIGHT.getId():
								return true;
						}
					}
			}
			
			Coordinate casetest1=new Coordinate((byte) (c.getRow()-1),(byte) (c.getCol()-1));
			Coordinate casetest2=new Coordinate((byte) (c.getRow()-1),(byte) (c.getCol()+1));
			
			if(this.getPosCase(casetest1)==Piece.BLACKPAWN.getId() || this.getPosCase(casetest2)==Piece.BLACKPAWN.getId()) {
				return true;
			}
			
			directions=Piece.WHITEKING.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId() :
								break;
							case Piece.BLACKKING.getId():
								return true;
						}
					}
			}
			return false;
		}
		
		else { // Player with Dark Pieces
			directions=Piece.BLACKROOK.getDirection();
			for(byte [] direction : directions) {// rook direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				boolean keepgoing=true;
				while((keepgoing) && (isOnChessboard(casetest))) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case 0 :
								break;
							case Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId(): 
								keepgoing=false;
								break;
							case Piece.WHITEROOK.getId(),Piece.WHITEQUEEN.getId():
								return true;
						}
					}
			}
			
			directions=Piece.BLACKBISHOP.getDirection();
			for(byte [] direction : directions) {// Bishop direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKKING.getId():
								break;
							case Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId():
								return true;
						}
					}
			}
			
			directions=Piece.BLACKKNIGHT.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case  ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId():
								break;
							case Piece.WHITEKNIGHT.getId():
								return true;
						}
					}
			}
			
			Coordinate casetest1=new Coordinate((byte) (c.getRow()+1),(byte) (c.getCol()-1));
			Coordinate casetest2=new Coordinate((byte) (c.getRow()+1),(byte) (c.getCol()+1));
			
			if(this.getPosCase(casetest1)==Piece.WHITEPAWN.getId() || this.getPosCase(casetest2)==Piece.WHITEPAWN.getId()) {
				return true;
			}
			
			directions=Piece.BLACKKING.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(c1);
				casetest.setRow(l);
				if(isOnChessboard(casetest)) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
						switch (this.getPosCase(casetest)) {
							case  ((byte) 0),Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.BLACKKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId():
								break;
							case Piece.WHITEKING.getId():
								return true;
						}
					}
			}
			return false;
		}
	}
	
	public boolean isChecked() {
		Coordinate c= new Coordinate((byte) 0, (byte) 0);
		boolean test=true;
		if(this.getTurn()==true) { // Player with White Pieces
			for(byte l=0; l<8; l++) {
				for(byte col=0; col<8; col++) {
					c.setCol(col);
					c.setRow(l);
					if (this.getPosCase(c)==Piece.WHITEKING.getId()) {
						 test=isControlled(c);
					}
				}
			}
		}
		else{ //Player with Black Pieces
			for(byte l=0; l<8; l++) {
				for(byte col=0; col<8; col++) {
					c.setCol(col);
					c.setRow(l);
					if (this.getPosCase(c)==Piece.BLACKKING.getId()) {
						test=isControlled(c);
					}
				}
			}
		}
		return test;
	}

	public void movePiece(Coordinate c1, Coordinate c2) {
		byte piece = this.getPosCase(c1);
		this.setPosCase(c1,(byte)0);
		this.setPosCase(c2, piece);
	}
	
	public byte testAdd(Position p, Coordinate c1, Coordinate c2, boolean b) {
		return 1;
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
	        		chessboard = chessboard + "| \u2656 ";
	        		break;
	        	case 2:
	        		chessboard = chessboard + "| \u2658 ";
	        		break;
	        	case 3:
	        		chessboard = chessboard + "| \u2657 ";
	        		break;
	        	case 4:
	        		chessboard = chessboard + "| \u2655 ";
	        		break;
	        	case 5:
	        		chessboard = chessboard + "| \u2654 ";
	        		break;
	        	case 6:
	        		chessboard = chessboard + "| \u2659 ";
	        		break;	
	        	case 7:
	        		chessboard = chessboard + "| \u265F ";
	        		break;
	        	case 8:
	        		chessboard = chessboard + "| \u265C ";
	        		break;
	        	case 9:
	        		chessboard = chessboard + "| \u265E ";
	        		break;
	        	case 10:
	        		chessboard = chessboard + "| \u265D ";
	        		break;
	        	case 11:
	        		chessboard = chessboard + "| \u265B ";
	        		break;
	        	case 12:
	        		chessboard = chessboard + "| \u265A ";
	        		break;
	        	}
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
