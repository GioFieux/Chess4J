

//définir equals pour Coordinate !
//définir un nouveau constructeur pour Coordinate ! (qui prend en arg une String)

//rajouter les constant a1 h1 a8 h8 au tout début le classe position (pour détecter les tour qui bouge de leur case de départ
// OBSOLETE : en fait pas besion : rajouter les constante c1 g1 c8 g8 au tout dbut pour la classe position (pour détecter les roques)
public void pseudoPlayMove(Coordinate c1, Coordinate c2){
	
	this.setEnPassant(null);
	
	switch(this.getPosCase(c1)){
		case WHITEROOK.id:
			if(c1.equals(a1)){
				this.setWhiteCastleLong(false);
			}
			if(c1.equals(h1)){
				this.setWhiteCastle(false);
			}
		case BLACKROOK.id:
			if(c1.equals(a8)){
				this.setBlackCastleLong(false);
			}
			if(c1.equals(h8)){
				this.setBlackCastle(false);
			}
		case WHITEKNIGHT.id:
		case BLACKKNIGHT.id:
		case WHITEBISHOP;id:
		case BLACKBISHOP.id:
		case WHITEQUEEN;id:
		case BLACKQUEEN.id:
			movePiece(c1,c2);
			break;
			
			
			
		case WHITEKING.id:
			this.setWhiteCastleLong(false);
			this.setWhiteCastle(false);
			if( abs( c1.getCol() -  c2.getCol() ) == 2){			//traduit la condition d'un roque
				if( c2.getCol() == 2){
					movePiece(new Case("a1"),new Case("d1");
				}
				if( c2.getCol() == 6){
					movePiece(new Case("h1"),new Case("f1");
				}
			}
			movePiece(c1,c2);
			
		case BLACKKING.id:
			this.setBlackCastleLong(false);
			this.setBlackCastle(false);
			if( abs( c1.getCol() -  c2.getCol() ) == 2){			//traduit la condition d'un roque
				if( c2.getCol() == 2){
					movePiece(new Case("a8"),new Case("d8");
				}
				if( c2.getCol() == 6){
					movePiece(new Case("h8"),new Case("f8");
				}
			}
			movePiece(c1,c2);
		
		
		
		case BLACKPAWN.id:
		case WHITEPAWN.id:
			if( not( c1.getCol() == c2.getCol() ) && c2.getPosCase() == 0){					//traduit une condition de prise en passant (en chagnement de colonne sur une case vide)
				Coordinate ct = new Coordinate(c1.getRow(), c2.getCol());
				movePiece(c1,ct);
				movePiece(ct,c2);
			}
			else{																					//pour tout le reste, déplacement normal, prise et aussi promotion)
				movePiece(c1,c2);
			}
			if( abs( c1.getRow() - c2.getRow() == 2){
				this.setEnPassant(new Coordinate( (c1.getRow()+c2.getRow())/2,c1.getCol());				//si un déplacement de pion de 2 case : alors une prsie en passant est possible
			}
			
		
	}
}

//position doit implémenter clonable !!!
public byte testAdd(Coordinate c1, Coordinate c2, boolean take){
	Position positionTMP = this.clone();
	positionTMP.pseudoPlayMove(c1,c2);
	if(positionTMP.isCheck()){
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