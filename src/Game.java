import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private String PGN;
    private Timer timeP1;
    private Timer timeP2;
    private boolean displayMode;

    public Game(String pgn) {
        this.PGN = pgn;
        this.timeP1 = new Timer();
        this.timeP2 = new Timer();
        this.displayMode = true;
    }

    public String getPGN() {
        return this.PGN;
    }

    public void setPGN(String s) {
        this.PGN = s;
    }

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

    public boolean getDisplayMode() {
        return this.displayMode;
    }

    public void setDisplayMode(boolean b) {
        this.displayMode = b;
    }

    public Timer getTimerP1() {
        return this.timeP1;
    }

    public Timer getTimerP2() {
        return this.timeP2;
    }

    /*
     * public boolean timedOut() {
     * 
     * TimerTask task1 = new TimerTask() {
     * 
     * int secondes = 5;
     * int minutes = 1;
     * 
     * @Override
     * public void run() {
     * if(secondes>0) {
     * System.out.println(minutes + ":" + secondes);
     * secondes--;
     * } else if(secondes==0 && minutes==0) {
     * System.out.println("time finished");
     * timeP1.cancel();
     * } else if (secondes==0) {
     * System.out.println(minutes + ":" + secondes);
     * minutes--;
     * secondes=5;
     * }
     * }
     * };
     * timeP1.scheduleAtFixedRate(task1, 0, 1000);
     * //timer.schedule(task, 0);
     * //timer.schedule(task, date.getTime());
     * //timer.scheduleAtFixedRate(task, 0, 1000);
     * return true;
     * }
     */

}
