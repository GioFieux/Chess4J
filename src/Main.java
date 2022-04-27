public class Main {
	
	public static void main(String[] args) {
		Position jeu = new Position();
		System.out.println(jeu);
		System.out.println(jeu.getPosCase(new Coordinate((byte)6,(byte)2)));
		//jeu.setTurn(false);
		jeu.setEnPassant(new Coordinate((byte)2,(byte)2));
		jeu.movePiece(new Coordinate((byte) 6,(byte) 3), new Coordinate((byte) 3,(byte) 3));
		jeu.movePiece(new Coordinate((byte) 1,(byte) 2), new Coordinate((byte) 3,(byte) 2));
		jeu.movePiece(new Coordinate((byte) 7,(byte) 0), new Coordinate((byte) 4,(byte) 4));
		System.out.println(jeu);
		jeu.caseAccess(new Coordinate((byte)3,(byte)3));
		//Game game = new Game("ss");
		//boolean b = game.timedOut();
	}
}
