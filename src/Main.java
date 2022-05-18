import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.*;

public class Main {

    public static void main(String[] args) throws NotAccessibleCaseException, NotLegalEntreeCaseException {

        Scanner sc = new Scanner(System.in);

        Position jeu = new Position();

        Game g = new Game("");

        Coordinate c1 = null;
        Coordinate c2 = null;

        System.out.println(jeu);

        int numberMove = 1;
        boolean keepgoing = true;
        // boolean stop = false;

        while (keepgoing) {

            boolean verified = false;
            while (!verified) {

                System.out.println("Enter a coordinate");
                String str = sc.nextLine();

                /*
                 * if (str.equals("stop")) {
                 * keepgoing = false;
                 * verified = true;
                 * } else
                 */
                if (!(str.length() == 2) || (str.charAt(1) > 8 && str.charAt(1) < 1)
                        || (str.charAt(0) < 97 && str.charAt(0) > 104)) {
                    System.out.println("Vous n'avez pas entr�e une cha�ne de caract�re l�gal");
                } else {
                    verified = true;
                    c1 = new Coordinate(str);
                }
            }

            String piece1 = jeu.getAffichage(c1);
            String piece2 = null;

            System.out.println("Here are the reachable cases");
            byte[][] accessible = jeu.caseAccess(c1);
            jeu.displayCaseAccess(accessible);

            String str2;

            do {
                System.out.println("Enter a second case");
                str2 = sc.nextLine();
                /*
                 * if (str2.equals("stop")) {
                 * stop = true;
                 * break;
                 * }
                 */
                try {
                    c2 = new Coordinate(str2);
                    piece2 = jeu.getAffichage(c2);
                    jeu.playMove(c1, c2, g, Piece.WHITEROOK);
                } catch (NotAccessibleCaseException e) {
                    System.out.println("Vous n'avez pas entré une case accessible");
                }
            } while (accessible[c2.getRow()][c2.getCol()] == 0);

            // test
            if (jeu.isCheckMate()) {
                break;
            }
            jeu.setTurn(!(jeu.getTurn()));
            if (jeu.isStaleMate()) {
                break;
            }
            jeu.setTurn(!(jeu.getTurn()));

            System.out.println("bravo, c'est un coup valide :");

            // if (!stop) {
            g.updatePGN(c1, c2, piece1, piece2, numberMove);
            // }

            System.out.println("PGN : \n" + g.getPGN());
            System.out.println(jeu);
            numberMove++;
        }

        if (jeu.isCheckMate()) {
            if (jeu.getTurn()) {
                System.out.println("Victoire des noirs par �chec et mat");
            } else {
                System.out.println("Victoire des blancs par �chec et mat");
            }
        } else {
            System.out.println("Match nul par PAT");
        }
        System.out.println("Fin de la partie");

        // Sérialisation
        /*
         * ArrayList<Position> al = new ArrayList<Position>();
         * al.add(jeu);
         * try {
         * FileOutputStream fileOut = new FileOutputStream("test");
         * ObjectOutputStream out = new ObjectOutputStream(fileOut);
         * out.writeObject(al);
         * out.close();
         * fileOut.close();
         * sc.close();
         * } catch (FileNotFoundException e) {
         * e.printStackTrace();
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         */

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
