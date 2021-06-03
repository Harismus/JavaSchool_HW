package cache;

import java.io.*;
import java.nio.file.Path;
import java.util.Optional;

public class CacheFile  implements ICachePlace{
    Path dirCache;
    public CacheFile(Path dirCache) {
        this.dirCache = dirCache;
    }

    public void set(String fileName, Object[] args, Object invoke) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream( dirCache.toString() + fileName + ".cache" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );

            Data data = new Data( fileName, args, invoke );
            objectOutputStream.writeObject( data );

            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage() );
        } catch (NotSerializableException e) {
            System.out.println( "e.getMessage() = " + e.getMessage() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Data> get(String fileName, Object[] args) {
        FileInputStream fileInputStream = null;
        Data cache = null;
        try {
            fileInputStream = new FileInputStream(  dirCache.toString() + fileName + ".cache" );
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            Data data = (Data) objectInputStream.readObject();

            cache = data.equals( null ) ? null : data;
        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage() );
        } catch (NotSerializableException e) {
            System.out.println( e.getMessage() );
        } catch (ClassNotFoundException e) {
            System.out.println( e.getMessage() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable( cache );
    }
}
