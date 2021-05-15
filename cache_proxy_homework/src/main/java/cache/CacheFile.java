package cache;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Optional;

public class CacheFile  implements ICachePlace{
    Path dirCache;
    CacheFile( Path dirCache) {
        this.dirCache = dirCache;
    }

    public void set(String methodName, Object[] args, Object invoke) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream( dirCache.toString() + methodName + ".cache" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );

            Data data = new Data( methodName, args, invoke );
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

    public boolean contains(Method method, Object[] args) {
        return true;
    }

    public Optional<Object> get(Method method, Object[] args) { //!< тут не используется
        return Optional.empty();
    }

    @Override
    public Optional<Object> get(String methodName) {
        FileInputStream fileInputStream = null;
        Object cache = null;
        try {
            fileInputStream = new FileInputStream(  dirCache.toString() + methodName + ".cache" );
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            Data data = (Data) objectInputStream.readObject() ;
            cache = data.equals( null ) ? null : data.getInvoke();
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
