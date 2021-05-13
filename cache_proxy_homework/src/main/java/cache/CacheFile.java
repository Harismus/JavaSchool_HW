package cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

public class CacheFile {
    public  <T> Optional<T> get(String nameMethod) {
        FileInputStream fileInputStream = null;
        T cache = null;
        try {
            fileInputStream = new FileInputStream(nameMethod) ;
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cache = (T) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.of(cache);
    }
}
