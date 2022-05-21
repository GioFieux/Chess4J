import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DesezializeObject {
    public static ArrayList<Position> main(String[] args) {
        ArrayList<Position> jeu = new ArrayList<Position>();
        try {
            FileInputStream fis = new FileInputStream("src/save/save.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Position pos = (Position) ois.readObject();
            jeu.add(pos);
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jeu;
    }
}