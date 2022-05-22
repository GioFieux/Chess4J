import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeGame {
    public static ArrayList<Game> main(String[] args) {
        ArrayList<Game> g = new ArrayList<Game>();
        try {
            FileInputStream fis = new FileInputStream("save/saveGame.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Game game = (Game) ois.readObject();
            g.add(game);
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return g;
    }
}