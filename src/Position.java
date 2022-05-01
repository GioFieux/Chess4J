import java.util.Arrays;

public class Position{
	
	private final Coordinate a1 = new Coordinate("a1");
	private final Coordinate a8 = new Coordinate("a8");
	private final Coordinate h1 = new Coordinate("h1");
	private final Coordinate h8 = new Coordinate("h8");
	private final Coordinate c1 = new Coordinate("c1");
	private final Coordinate d1 = new Coordinate("d1");
	private final Coordinate f1 = new Coordinate("f1");
	private final Coordinate g1 = new Coordinate("g1");
	private final Coordinate c8 = new Coordinate("c8");
	private final Coordinate d8 = new Coordinate("d8");
	private final Coordinate f8 = new Coordinate("f8");
	private final Coordinate g8 = new Coordinate("g8");
	
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
		byte[][] tmp = caseAccess(c1); // value of caseAccess(c1) in an array of array of byte

		if (tmp[c2.getRow()][c2.getCol()] > 0) { // check if c2 is in tmp (value of caseAccess(c1))
			pseudoPlayMove(c1,c2);
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
	//�a doit �tre un private hein
	public void pseudoPlayMove(Coordinate c1, Coordinate c2){
		
		this.setEnPassant(null);
		
		switch(this.getPosCase(c1)){
			case 1: //WHITEROOK
				if(c1.equals(a1)){
					this.setWhiteCastleLong(false);
				}
				if(c1.equals(h1)){
					this.setWhiteCastle(false);
				}
			case 8: //BLACKROOK
				if(c1.equals(a8)){
					this.setBlackCastleLong(false);
				}
				if(c1.equals(h8)){
					this.setBlackCastle(false);
				}
			case 2: //WHITEKNIGHT.id:
			case 9: //BLACKKNIGHT.id:
			case 3: //WHITEBISHOP;id:
			case 10: //BLACKBISHOP.id:
			case 4: //WHITEQUEEN;id:
			case 11: //BLACKQUEEN.id:
				movePiece(c1,c2);
				break;
				
				
				
			case 5: //WHITEKING.id:
				this.setWhiteCastleLong(false);
				this.setWhiteCastle(false);
				if( Math.abs( c1.getCol() -  c2.getCol() ) == 2){			//traduit la condition d'un roque
					if( c2.getCol() == 2){
						movePiece(new Coordinate("a1"),new Coordinate("d1"));
					}
					if( c2.getCol() == 6){
						movePiece(new Coordinate("h1"),new Coordinate("f1"));
					}
				}
				movePiece(c1,c2);
				
			case 12: //BLACKKING.id:
				this.setBlackCastleLong(false);
				this.setBlackCastle(false);
				if( Math.abs( c1.getCol() -  c2.getCol() ) == 2){			//traduit la condition d'un roque
					if( c2.getCol() == 2){
						movePiece(new Coordinate("a8"),new Coordinate("d8"));
					}
					if( c2.getCol() == 6){
						movePiece(new Coordinate("h8"),new Coordinate("f8"));
					}
				}
				movePiece(c1,c2);
			
			
			
			case 6: //WHITEPAWN.id:
			case 7: //BalckEPAWN.id:
				if( !( c1.getCol() == c2.getCol() ) && this.getPosCase(c2) == 0){		//traduit une condition de prise en passant (en chagnement de colonne sur une case vide)
					Coordinate ct = new Coordinate(c1.getRow(), c2.getCol());
					movePiece(c1,ct);
					movePiece(ct,c2);
				}
				else{																					//pour tout le reste, d�placement normal, prise et aussi promotion)
					movePiece(c1,c2);
				}
				if( Math.abs( c1.getRow() - c2.getRow()) == 2) {
					this.setEnPassant(new Coordinate( (byte) ( (c1.getRow()+c2.getRow())/2),c1.getCol()));				//si un d�placement de pion de 2 case : alors une prsie en passant est possible
				}
				
			
		}
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
						if (this.isControlled(f1)&& this.isControlled(g1)) {
							resultMatrix[g1.getRow()][g1.getCol()]=1;
						}
					} else if (this.getWhiteCastleLong()) {
						if (this.isControlled(c1)&& this.isControlled(d1)) {
							resultMatrix[c1.getRow()][c1.getCol()]=1;
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
						if (this.isControlled(f8)&& this.isControlled(g8)) {
							resultMatrix[g8.getRow()][g8.getCol()]=1;
						}
					} else if (this.getBlackCastleLong()) {
						if (this.isControlled(c8)&& this.isControlled(d8)) {
							resultMatrix[c8.getRow()][c8.getCol()]=1;
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
			int y = c.getCol();
			int x = c.getRow();
			cTest.setCol((byte)y);
			cTest.setRow((byte)x);
			
			while(step<limit && keepgoing) {
				
				x = x + deltaX;
				y = y + deltaY;
				
				cTest.setRow((byte)x);
				cTest.setCol((byte)y);
				if(isOnChessboard(cTest)) {
					switch(this.getPosCase(cTest)) {
					case 0:					 //empty case
						resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, false);
						break;
					case 7,8,9,10,11,12:     
						if (team) { //enemy piece for white player
							resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
						}
						keepgoing=false;
						break;
					case 1,2,3,4,5,6:		 
						if (!team) { //ennemy piece for black player
							resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
						} 
						keepgoing=false;
						break;
					}
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
				resultMatrix[cTest2.getRow()][cTest2.getCol()]=this.testAdd(c, cTest2, false);
				//if (true) {//if(testAdd(this, c, cTest2, false)==1) {
					if(this.getPosCase(cTest)==0) {
						resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest2, false);
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
		
		//Coordinate accessEnPassant = this.getEnPassant();
		
		if(isOnChessboard(cTest)) {
			switch(this.getPosCase(cTest)) {
			case 7,8,9,10,11,12:     
				if (team) { //enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
				} else { 	//allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, false);
				}
				break;
			case 1,2,3,4,5,6:		 
				if (team) { //allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, false);
				} else { 	//enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
				}
				break;
			}
			
			/*if(accessEnPassant.equals(cTest) && c.getRow()==enPassantRow) { //case prise en passant
				resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()]=this.testAdd(c,cTest,true);
			}*/
		}
		
		a = c.getRow() + iLeft[0];
		b = c.getCol() + iLeft[1];
		
		cTest.setRow((byte)a);
		cTest.setCol((byte)b);
		
		if(isOnChessboard(cTest)) {
			switch(this.getPosCase(cTest)) {
			case 7,8,9,10,11,12:     
				if (team) { //enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
				} else { 	//allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, false);
				}
				break;
			case 1,2,3,4,5,6:		 
				if (team) { //allied piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, false);
				} else { 	//enemy piece for white player
					resultMatrix[cTest.getRow()][cTest.getCol()]=this.testAdd(c, cTest, true);
				}
				break;
			}
			
			/*if(accessEnPassant.equals(cTest) && c.getRow()==enPassantRow) { //case prise en passant
				resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()]=this.testAdd(c,cTest,true);
			}*/
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
		byte co=c.getCol();
		Coordinate casetest = new Coordinate((byte) 0, (byte) 0) ;
		byte [][] directions;
		if (this.getTurn()==true){// Player with White Pieces
			directions=Piece.WHITEROOK.getDirection();
			for(byte [] direction : directions) {// rook direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(co);
				casetest.setRow(l);
				boolean keepgoing=true;
				while(keepgoing) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
					if(isOnChessboard(casetest)) {
						switch (this.getPosCase(casetest)) {
							case 0 :
								break;
							case 1,2,3,4,5,6,7,9,10,12://Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKKING.getId(): 
								keepgoing=false;
								break;
							case 8,11://Piece.BLACKROOK.getId(),Piece.BLACKQUEEN.getId():
								return true;
						}
					}
					else {
						keepgoing=false;
					}
				}
				
			}
			
			directions=Piece.WHITEBISHOP.getDirection();
			for(byte [] direction : directions) {// Bishop direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(co);
				casetest.setRow(l);
				boolean keepgoing=true;
				while(keepgoing) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
					if(isOnChessboard(casetest)) {
						
							switch (this.getPosCase(casetest)) {
								case 0,1,2,3,4,5,6,7,8,9,12: //Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKKING.getId() :
									keepgoing=false;
									break;
								case  10,11://Piece.BLACKQUEEN.getId(),Piece.BLACKBISHOP.getId():
									return true;
							}
					}
					else {
						keepgoing=false;
					}
				}
			}
			
			directions=Piece.WHITEKNIGHT.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(co);
				casetest.setRow(l);
				casetest.setCol((byte) (casetest.getCol()+dy));
				casetest.setRow((byte) (casetest.getRow()+dx));
				if(isOnChessboard(casetest)) {
					
						switch (this.getPosCase(casetest)) {
							case 0,1,2,3,4,5,6,7,8,10,11,12://Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId() :
								break;
							case 9://Piece.BLACKKNIGHT.getId():
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
				casetest.setCol(co);
				casetest.setRow(l);
				casetest.setCol((byte) (casetest.getCol()+dy));
				casetest.setRow((byte) (casetest.getRow()+dx));
				if(isOnChessboard(casetest)) {
					
						switch (this.getPosCase(casetest)) {
							case 0,1,2,3,4,5,6,7,8,9,10,11: //Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId() :
								break;
							case 12://Piece.BLACKKING.getId():
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
				casetest.setCol(co);
				casetest.setRow(l);
				boolean keepgoing=true;
				while(keepgoing) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
					if(isOnChessboard(casetest)) {	
						switch (this.getPosCase(casetest)) {
							case 0 :
								break;
							case 2,3,5,6,7,8,9,10,11,12://Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId(): 
								keepgoing=false;
								break;
							case 1,4://Piece.WHITEROOK.getId(),Piece.WHITEQUEEN.getId():
								return true;
						}
					}
					else {
						keepgoing=false;
					}
				}
			}
			
			directions=Piece.BLACKBISHOP.getDirection();
			for(byte [] direction : directions) {// Bishop direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(co);
				casetest.setRow(l);
				boolean keepgoing=true;
				while(keepgoing) {
					casetest.setCol((byte) (casetest.getCol()+dy));
					casetest.setRow((byte) (casetest.getRow()+dx));
					if(isOnChessboard(casetest)) {
							switch (this.getPosCase(casetest)) {
								case 0,1,2,5,6,7,8,9,10,11,12://Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKKING.getId():
									keepgoing=false;
									break;
								case 3,4://Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId():
									return true;
							}
						}
					else {
						keepgoing=false;
					}
				}
			}
			
			directions=Piece.BLACKKNIGHT.getDirection();
			for(byte [] direction : directions) {// Knight direction
				byte dx= direction[0];
				byte dy= direction[1]; 
				casetest.setCol(co);
				casetest.setRow(l);
				casetest.setCol((byte) (casetest.getCol()+dy));
				casetest.setRow((byte) (casetest.getRow()+dx));
				if(isOnChessboard(casetest)) {
					
						switch (this.getPosCase(casetest)) {
							case  0,1,3,4,5,6,7,8,9,10,11,12://Piece.WHITEROOK.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.WHITEKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId(),Piece.BLACKKING.getId():
								break;
							case 2://Piece.WHITEKNIGHT.getId():
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
				casetest.setCol(co);
				casetest.setRow(l);
				casetest.setCol((byte) (casetest.getCol()+dy));
				casetest.setRow((byte) (casetest.getRow()+dx));
				if(isOnChessboard(casetest)) {
						switch (this.getPosCase(casetest)) {
							case 0,1,2,3,4,6,7,8,9,10,11,12://Piece.WHITEROOK.getId(),Piece.WHITEKNIGHT.getId(),Piece.WHITEBISHOP.getId(),Piece.WHITEQUEEN.getId(),Piece.BLACKKING.getId(),Piece.WHITEPAWN.getId(),Piece.BLACKPAWN.getId(),Piece.BLACKROOK.getId(),Piece.BLACKKNIGHT.getId(),Piece.BLACKBISHOP.getId(),Piece.BLACKQUEEN.getId():
								break;
							case 5://Piece.WHITEKING.getId():
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
	
	public byte testAdd(Coordinate c1, Coordinate c2, boolean take){
		Position positionTMP = this.badcopy();
		positionTMP.pseudoPlayMove(c1,c2);
		if(positionTMP.isChecked()){
			return 0;
		}
		else{
			if(take){
				return 2;
			}
			else{
				return 1;
			}
		}
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
	
	//I have no idea if the method clone is working for now
	public Position badcopy(){
		Position badclone = new Position();
		badclone.setPos(this.getPos());
		badclone.setTurn(this.getTurn());
		
		//� priori tout ces setter sont turbo useless puisqu'on utilise tout �a uniquement dans test add ... faudrai faire des test pour voir s'il y en a vraiment besion histoie de gagner du COMPUTATION TIME
		badclone.setBlackCastle(this.getBlackCastleLong());
		badclone.setBlackCastleLong(this.getBlackCastleLong());
		badclone.setWhiteCastle(this.getWhiteCastle());
		badclone.setWhiteCastleLong(this.getWhiteCastleLong());
		badclone.setEnPassant(this.getEnPassant());
		
        return badclone;
    }
}
