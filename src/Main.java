import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotAccessibleCaseException, NotLegalEntreeCaseException {

        Scanner sc = new Scanner(System.in);

        Position jeu = new Position();

        Game g = new Game("");
        g.getTimerP1().start();
        g.getTimerP1().pause();
        g.getTimerP2().start();

        Coordinate c1 = null;
        Coordinate c2 = null;

        System.out.println(jeu);

        int numberMove = 1;

        while (!jeu.isGameFinished(g)) {

            if (jeu.getTurn()) {
                g.getTimerP1().resume();
                g.getTimerP2().pause();
            } else {
                g.getTimerP1().pause();
                g.getTimerP2().resume();
            }

            boolean verified = false;
            while (!verified) {

                System.out.println("Enter a coordinate");
                String str = sc.nextLine();

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
                try {
                    c2 = new Coordinate(str2);
                    piece2 = jeu.getAffichage(c2);
                    jeu.playMove(c1, c2, g, Piece.WHITEQUEEN);
                } catch (NotAccessibleCaseException e) {
                    System.out.println("Vous n'avez pas entré une case accessible");
                }
            } while (accessible[c2.getRow()][c2.getCol()] == 0);

            System.out.println("bravo, c'est un coup valide :");

            g.updatePGN(c1, c2, piece1, piece2, numberMove);

            System.out.println("PGN : \n" + g.getPGN());
            System.out.println(jeu);
            System.out.println("Temps P1 : " + Chrono.timeToHMS(g.getTimerP1Time()));
            System.out.println("Temps P2 : " + Chrono.timeToHMS(g.getTimerP2Time()));
            numberMove++;
        }

        // stop timer
        if (jeu.getTurn()) {
            g.getTimerP1().resume();
        } else {
            g.getTimerP2().resume();
        }
        g.getTimerP1().stop();
        g.getTimerP2().stop();

        // searching for winner and why
        if (jeu.isCheckMate()) {
            if (jeu.getTurn()) {
                System.out.println("Victoire des noirs par échec et mat");
            } else {
                System.out.println("Victoire des blancs par échec et mat");
            }
        } else if (g.timeOutP1()) {
            System.out.println("Victoire des noirs par temps passé des blancs");
        } else if (g.timeOutP2()) {
            System.out.println("Victoire des blancs par temps passé des noirs");
        } else {
            System.out.println("Match nul par PAT");
        }

        System.out.println("Temps restant Player 1 : " + Chrono.timeToHMS(g.getTimerP1Time()));
        System.out.println("Temps restant Player 2 : " + Chrono.timeToHMS(g.getTimerP2Time()));
        System.out.println("Fin de la partie");

        // serialization
        /*
         * SerializePosition.main(jeu);
         * SerializeGame.main(g);
         * 
         * // deserialization
         * System.out.println("jeu après deserialisation : ");
         * 
         * ArrayList<Position> posList = DeserializePosition.main(args);
         * ArrayList<Game> gameList = DeserializeGame.main(args);
         * System.out.println(posList.get(0));
         * System.out.println("Temps restant Player 1 : " +
         * Chrono.timeToHMS(gameList.get(0).getTimerP1Time()));
         * System.out.println("Temps restant Player 2 : " +
         * Chrono.timeToHMS(gameList.get(0).getTimerP2Time()));
         */
        sc.close();
    }
}