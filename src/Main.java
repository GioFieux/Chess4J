import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Position jeu = new Position();

        Game g = new Game("blabla le black king ça marche");
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

        while (true) {
            // System.out.println("isCheckMate() : " + jeu.isCheckMate());
            System.out.println("Enter a coordinate");
            String str = sc.nextLine();
            c1 = new Coordinate(str);

            System.out.println("here are the reachable cases");
            byte[][] accessible = jeu.caseAccess(c1); // warning : this line also display the reachable cases
            jeu.displayCaseAccess(accessible);

            System.out.println("Enter a second case");
            str = sc.nextLine();
            c2 = new Coordinate(str);

            System.out.println("bravo, c'est un coup valide :");
            jeu.playMove(c1, c2, g);
            // jeu.setTurn(!(jeu.getTurn()));

            System.out.println(jeu);

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
