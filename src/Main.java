import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

            System.out.println("Enter a second case");
            str = sc.nextLine();
            c2 = new Coordinate(str);
            
            String piece2 = jeu.getAffichage(c2);

            System.out.println("bravo, c'est un coup valide :");
            
            jeu.playMove(c1, c2, g);
            
            if(piece2.equals("   ")) {
            	g.setPGN(g.getPGN() + numberMove + ". " + c1.byteConversionToString()[0] + c1.byteConversionToString()[1] + " " + piece1 + c2.byteConversionToString()[0] + c2.byteConversionToString()[1] + "\n");
            } else {
            	
            }
            
            System.out.println("PGN : " + g.getPGN());
            System.out.println(jeu);
            numberMove++;
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
