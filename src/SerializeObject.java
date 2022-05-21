import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeObject {
    public static void main(Position pos) {
        try {
            FileOutputStream fos = new FileOutputStream("src/save/save.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pos);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}