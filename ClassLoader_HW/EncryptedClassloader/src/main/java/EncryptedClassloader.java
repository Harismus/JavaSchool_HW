import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EncryptedClassloader extends ClassLoader {
    private final String key;
    private final File dir;
    private java.util.Map classesHash = new java.util.HashMap();

    public EncryptedClassloader(String key, File dir, ClassLoader parent) {
        //super( parent );
        this.key = key;
        this.dir = dir;
    }

    public ITestClass load(String className) {

        ITestClass testClass = null;
        try {
            Class<?> pluginClass = loadClass( "",  className, true );
            testClass = (ITestClass) pluginClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return testClass;
    }

    private byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream( file );
        try {
            f.read( result, 0, result.length );
        } finally {
            try {
                f.close();
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] += Byte.valueOf( key );
        }

        return result;
    }

    private Class findClass(String pluginName, String pluginClassName) throws ClassNotFoundException {
        Class result = (Class) classesHash.get( pluginClassName ); //!< смотрим есть ли в кеше
        if (result != null) {
            return result;
        }

        File pluginFile = new File( dir + "\\" + pluginName + "\\" + pluginClassName + ".class" );

        try {
            byte[] classBytes = loadFileAsBytes( pluginFile );
            result = defineClass( pluginClassName, classBytes, 0, classBytes.length );

        } catch (IOException e) {
            throw new ClassNotFoundException( "Cannot load class " + pluginClassName + ": " + e );
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException( "Format of class file incorrect for class " + pluginClassName + ": " + e );
        }

        classesHash.put( pluginClassName, result );
        return result;
    }


    public Class loadClass( String pluginName, String pluginClassName, boolean resolve) throws ClassNotFoundException {
        Class result = findClass( pluginName, pluginClassName );
        if (resolve)
            resolveClass( result );

        return result;
    }
}