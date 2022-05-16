import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotAccessibleCaseException {

        Scanner sc = new Scanner(System.in);

        Position jeu = new Position();

        Game g = new Game("");
        /*
         * System.out.println(jeu);
         * 
         * jeu.testAdd(new Coordinate("e2"),new Coordinate("e4"),true);
         * 
         * System.out.println(jeu);
         * 
         */

        Coordinate c1 = null;
        Coordinate c2 = null;
        
        System.out.println(jeu);
        
        int numberMove=1;

        while ( !(jeu.isCheckMate()) || !(jeu.isStaleMate()) ) {
            // System.out.println("isCheckMate() : " + jeu.isCheckMate());
            System.out.println("Enter a coordinate");
            String str = sc.nextLine();
            c1 = new Coordinate(str);
            
            String piece1 = jeu.getAffichage(c1);
            
            System.out.println("Here are the reachable cases");
            byte[][] accessible = jeu.caseAccess(c1); 
            jeu.displayCaseAccess(accessible);
            
            boolean done=false;
            
            do {
	            try {
	            	System.out.println("Enter a second case");
	                str = sc.nextLine();
	                c2 = new Coordinate(str);
	            	jeu.playMove(c1, c2, g);
	            	done=true;
	            } catch (NotAccessibleCaseException e) {
	            	System.out.println("Veuillez faire le nécessaire");
	            	System.out.println("Enter a second case");
	                str = sc.nextLine();
	                c2 = new Coordinate(str);
	                jeu.playMove(c1, c2, g);
	                continue;
	            } 
            } while (!done);
            
            String piece2 = jeu.getAffichage(c2);

            System.out.println("bravo, c'est un coup valide :");
            
            g.updatePGN(c1, c2, piece1, piece2, numberMove);
            
            System.out.println("PGN : \n" + g.getPGN());
            System.out.println(jeu);
            numberMove++;
        }
        
        if (jeu.getTurn()) {
        	System.out.println("Victoire des ");
        } else {
        	System.out.println("Victoire des ");
        }
        

        // for testting purpose only
        /*
         * while(true) {
         * System.out.println("Enter a coordinate");
         * 
         * String str = sc.nextLine();
         * Coordinate c1 = new Coordinate(str);
         * 
         * System.out.println("co : "+c1.getCol()+c1.getRow());
         * 
         * }
         */

        // old
        /*
         * System.out.println(jeu.getPosCase(new Coordinate((byte)6,(byte)2)));
         * //jeu.setTurn(false);
         * jeu.setEnPassant(new Coordinate((byte)2,(byte)2));
         * jeu.movePiece(new Coordinate((byte) 6,(byte) 3), new Coordinate((byte)
         * 3,(byte) 3));
         * jeu.movePiece(new Coordinate((byte) 1,(byte) 2), new Coordinate((byte)
         * 3,(byte) 2));
         * jeu.movePiece(new Coordinate((byte) 7,(byte) 0), new Coordinate((byte)
         * 4,(byte) 4));
         * System.out.println(jeu);
         * jeu.caseAccess(new Coordinate((byte)3,(byte)3));
         * //Game game = new Game("ss");
         * //boolean b = game.timedOut(); -->
         */
    }
    
    
}
