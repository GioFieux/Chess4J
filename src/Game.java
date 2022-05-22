public class Game {
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

    public Chrono getTimerP1() {
        return this.timeP1;
    }

    public Chrono getTimerP2() {
        return this.timeP2;
    }

    public long getTimerP1Time() {
        if (this.getTimerP1().getTime() != 0) {
            duree1 = this.getTimerP1().getTime();
        }
        long tempsRestant = 600 - duree1;
        return tempsRestant;
    }

    public long getTimerP2Time() {
        if (this.getTimerP2().getTime() != 0) {
            duree2 = this.getTimerP2().getTime();
        }
        long tempsRestant = 600 - duree2;
        return tempsRestant;
    }

    public boolean timeOutP1() {
        return this.getTimerP1().timeOut();
    }

    public boolean timeOutP2() {
        return this.getTimerP2().timeOut();
    }

    /*
     * public int[] manageTimeP1() {
     * 
     * int[] tabtimeP1 = new int[2];
     * 
     * TimerTask task1 = new TimerTask() {
     * 
     * int secondes = 5;
     * int minutes = 1;
     * 
     * @Override
     * public void run() {
     * if (secondes > 0) {
     * System.out.println(minutes + ":" + secondes);
     * secondes--;
     * } else if (secondes == 0 && minutes == 0) {
     * System.out.println("time finished");
     * timeP1.cancel();
     * } else if (secondes == 0) {
     * System.out.println(minutes + ":" + secondes);
     * minutes--;
     * secondes = 5;
     * }
     * tabtimeP1[0] = minutes;
     * tabtimeP1[1] = secondes;
     * }
     * };
     * this.getTimerP1().scheduleAtFixedRate(task1, 0, 1000);
     * return tabtimeP1;
     * }
     * 
     * public int[] manageTimeP2() {
     * 
     * int[] tabtimeP2 = new int[2];
     * 
     * TimerTask task2 = new TimerTask() {
     * 
     * int secondes = 5;
     * int minutes = 1;
     * 
     * @Override
     * public void run() {
     * if (secondes > 0) {
     * System.out.println(minutes + ":" + secondes);
     * secondes--;
     * } else if (secondes == 0 && minutes == 0) {
     * System.out.println("time finished");
     * timeP1.cancel();
     * } else if (secondes == 0) {
     * System.out.println(minutes + ":" + secondes);
     * minutes--;
     * secondes = 5;
     * }
     * tabtimeP2[0] = minutes;
     * tabtimeP2[1] = secondes;
     * }
     * };
     * this.getTimerP2().scheduleAtFixedRate(task2, 0, 1000);
     * 
     * // timer.schedule(task, 0);
     * // timer.schedule(task, date.getTime());
     * // timer.scheduleAtFixedRate(task, 0, 1000);
     * return tabtimeP2;
     * }
     */

    /*
     * public static void main(String[] args) {
     * Game g = new Game("");
     * int[] tabtimeP1 = g.manageTimeP1();
     * System.out.println("Player 1 : " + tabtimeP1[0] + " " + tabtimeP1[1]);
     * if (tabtimeP1[0] == 0) {
     * g.getTimerP1().cancel();
     * }
     * }
     */
}