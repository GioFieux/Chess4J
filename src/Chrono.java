import java.io.Serializable;
import java.util.Scanner;

public class Chrono implements Cloneable, Serializable {

    private long tempsDepart;
    private long tempsFin;
    private long pauseDepart;
    private long pauseFin;
    private long duree;
    private boolean resumed;

    public Chrono() {
        this.tempsDepart = 0;
        this.tempsFin = 0;
        this.pauseDepart = 0;
        this.pauseFin = 0;
        this.duree = 0;
        this.resumed = false;
    }

    public void start() {
        this.tempsDepart = System.currentTimeMillis();
        this.tempsFin = 0;
        this.pauseDepart = 0;
        this.pauseFin = 0;
        this.duree = 0;
    }

    public void pause() {
        if (this.tempsDepart == 0) {
            return;
        }
        this.pauseDepart = System.currentTimeMillis();
        this.resumed = false;
    }

    public void resume() {
        if (this.tempsDepart == 0) {
            return;
        }
        if (this.pauseDepart == 0) {
            return;
        }
        this.pauseFin = System.currentTimeMillis();
        this.tempsDepart = this.tempsDepart + this.pauseFin - this.pauseDepart;
        this.tempsFin = 0;
        this.pauseDepart = 0;
        this.pauseFin = 0;
        this.duree = 0;
        this.resumed = true;
    }

    public void stop() {
        if (this.tempsDepart == 0) {
            return;
        }
        this.tempsFin = System.currentTimeMillis();
        this.duree = (this.tempsFin - this.tempsDepart) - (this.pauseFin - this.pauseDepart);
        this.tempsDepart = 0;
        this.tempsFin = 0;
        this.pauseDepart = 0;
        this.pauseFin = 0;
    }

    public long getDureeSec() {
        return this.duree / 1000;
    }

    public long getDureeMs() {
        return this.duree;
    }

    public long getTime() {
        Chrono tmp = this.clone();
        if (this.resumed) {
            tmp.stop();
        }
        return tmp.getDureeSec();
    }

    public static String timeToHMS(long tempsS) {

        // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "1 h 26 min 3 s"

        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r = "";

        if (h > 0) {
            r += h + " h ";
        }
        if (m > 0) {
            r += m + " min ";
        }
        if (s > 0) {
            r += s + " s";
        }
        if (h <= 0 && m <= 0 && s <= 0) {
            r = "0 s";
        }

        return r;
    }

    public boolean timeOut() {
        if (this.getTime() > 600) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Chrono t1 = new Chrono();
        Chrono t2 = new Chrono();
        t1.start();
        t2.start();
        Scanner sc = new Scanner(System.in);
        boolean keepgoing = true;
        while (keepgoing) {
            System.out.println("Entrer une action");
            String str = sc.nextLine();
            if (str.equals("pause1")) {
                t1.pause();
            }
            if (str.equals("pause2")) {
                t2.pause();
            }
            if (str.equals("reprendre1")) {
                t1.resume();
            }
            if (str.equals("reprendre2")) {
                t2.resume();
            }
            if (str.equals("stop")) {
                t1.stop();
                t2.stop();
                keepgoing = false;
            }
        }
        System.out.println("Temps de jeu player 1 : " + Chrono.timeToHMS(t1.getDureeSec()));
        System.out.println("Temps de jeu player 2 : " + Chrono.timeToHMS(t2.getDureeSec()));
        sc.close();
    }

    public String toString() {
        String chrono = "";
        chrono = chrono + "duree       : " + this.getDureeSec() + "\n";
        chrono = chrono + "tempsDepart : " + this.tempsDepart + "\n";
        chrono = chrono + "tempsFin    : " + this.tempsFin + "\n";
        chrono = chrono + "pauseDepart : " + this.pauseDepart + "\n";
        chrono = chrono + "pauseFin    : " + this.pauseFin + "\n";
        return chrono;
    }

    public Chrono clone() {
        Chrono tmp = new Chrono();
        tmp.tempsDepart = this.tempsDepart;
        tmp.tempsFin = this.tempsFin;
        tmp.pauseDepart = this.pauseDepart;
        tmp.pauseFin = this.pauseFin;
        tmp.duree = this.duree;
        return tmp;
    }
}