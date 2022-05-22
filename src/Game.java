import java.io.Serializable;

/**
 * This class allows to manage every elements linked to every ChessGame, such as
 * PGN and time for both players.
 * 
 * @author Elias MEHIRA, Florent FRAITOT, Alexis JUST, Giovanni FIEUX
 * @version 1.0
 */

public class Game implements Serializable {
    private String PGN;
    private Chrono timeP1;
    private Chrono timeP2;
    private long duree1 = 0;
    private long duree2 = 0;

    public Game(String pgn) {
        this.PGN = pgn;
        this.timeP1 = new Chrono();
        this.timeP2 = new Chrono();
    }

    public String getPGN() {
        return this.PGN;
    }

    public void setPGN(String s) {
        this.PGN = s;
    }

    public Chrono getTimerP1() {
        return this.timeP1;
    }

    public Chrono getTimerP2() {
        return this.timeP2;
    }

    /**
     * This method updates the PGN and saves move pieces since the start of the
     * game, and the piece takes.
     * 
     * @param c1         : the initial case before the move of the piece.
     * @param c2         : the destination case of the piece.
     * @param piece1     : corresponds to the name of the piece played by the
     *                   player.
     * @param piece2     : corresponds to the enemy piece’s name taken by the
     *                   player’s piece or to an empty case if there is no take.
     * @param numberMove : corresponds to the number of moves played in a game.
     */
    public void updatePGN(Coordinate c1, Coordinate c2, String piece1, String piece2, int numberMove) {
        if (piece2.equals("  ")) {
            this.setPGN(this.getPGN() + numberMove + ". " + c1.byteConversionToString()[0]
                    + c1.byteConversionToString()[1] + " " + c2.byteConversionToString()[0]
                    + c2.byteConversionToString()[1] + " " + piece1 + "\n");
        } else {
            this.setPGN(this.getPGN() + numberMove + ". " + c1.byteConversionToString()[0]
                    + c1.byteConversionToString()[1] + " " + c2.byteConversionToString()[0]
                    + c2.byteConversionToString()[1] + " " + piece1 + "took " + piece2 + "\n");
        }
    }

    /**
     * This method calculates the time passed by White player since the Game began.
     * 
     * @return The time passed by White player
     */
    public long getTimerP1Time() {
        if (this.getTimerP1().getTime() != 0) {
            duree1 = this.getTimerP1().getTime();
        }
        long tempsRestant = 600 - duree1;
        return tempsRestant;
    }

    /**
     * This method calculates the time passed by Black player since the Game began.
     * 
     * @return The time passed by Black player
     */
    public long getTimerP2Time() {
        if (this.getTimerP2().getTime() != 0) {
            duree2 = this.getTimerP2().getTime();
        }
        long tempsRestant = 600 - duree2;
        return tempsRestant;
    }

    /**
     * This method checks if the time passed by White player since the Game began is
     * higher than 10 minutes
     * 
     * @return True if time passed by White player is higher than 10 minutes
     */
    public boolean timeOutP1() {
        return this.getTimerP1().timeOut();
    }

    /**
     * This method checks if the time passed by Black player since the Game began is
     * higher than 10 minutes
     * 
     * @return True if time passed by Black player is higher than 10 minutes
     */
    public boolean timeOutP2() {
        return this.getTimerP2().timeOut();
    }
}