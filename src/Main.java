import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		Position jeu = new Position();
		Game partie = new Game("tmptest");
		
		System.out.println(jeu);
		
		
		System.out.println("Enter a coordinate");
		
		String str = sc.nextLine();		
		Coordinate c1 = new Coordinate(str);
		Coordinate c2 = null;
		
		// tmp
		System.out.println(""+c1.getCol()+c1.getCol());
		
		while(true){
			
			System.out.println("here are the reachable cases");
			byte[][] accessible = jeu.caseAccess(c1); // warning : this line also display the reachable cases
			
			

			
			str = sc.nextLine();
			c2= new Coordinate(str);

			if(accessible[c2.getRow()][c2.getCol()] > 0){	// test if c2 is a reachable destination
				System.out.println("bravo, c'est un coup valide :");
				jeu.playMove(c1,c2,partie);
				System.out.println(jeu);
				
				System.out.println("joueur suivant, votre coup :");
				str = sc.nextLine();
				c1= new Coordinate(str);
			}
		  else{ 
			  System.out.println("ce n'est pas une case accessible ...");
			  c1 = c2;
		  }
		}
		
		
		
		
		
		
		/*
		System.out.println(jeu.getPosCase(new Coordinate((byte)6,(byte)2)));
		//jeu.setTurn(false);
		jeu.setEnPassant(new Coordinate((byte)2,(byte)2));
		jeu.movePiece(new Coordinate((byte) 6,(byte) 3), new Coordinate((byte) 3,(byte) 3));
		jeu.movePiece(new Coordinate((byte) 1,(byte) 2), new Coordinate((byte) 3,(byte) 2));
		jeu.movePiece(new Coordinate((byte) 7,(byte) 0), new Coordinate((byte) 4,(byte) 4));
		System.out.println(jeu);
		jeu.caseAccess(new Coordinate((byte)3,(byte)3));
		//Game game = new Game("ss");
		//boolean b = game.timedOut();		-->*/
	}
}
