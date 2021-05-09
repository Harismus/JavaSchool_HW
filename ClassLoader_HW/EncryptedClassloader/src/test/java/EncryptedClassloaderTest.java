import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Paths;

public class EncryptedClassloaderTest {
    final String key = "127";
    String classDir = "target" + File.separatorChar + "classes" + File.separatorChar;
    String inputClassName = "TestClass";

    EncryptedClassloader encryptedClassloader = new EncryptedClassloader( key, new File( Paths.get( classDir + ".." + File.separatorChar ).toAbsolutePath().toString() )
            , ClassLoader.getSystemClassLoader() );

    byte[] readClass(String inputClassname) {
        File classFile = new File( inputClassname );
        byte[] result = new byte[(int) classFile.length()];
        FileInputStream f = null;
        try {
            f = new FileInputStream( classFile );
            f.read( result, 0, result.length );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                f.close();
            } catch (Exception e) {
            }
        }

        return result;
    }

    void writeClass(byte[] buffer, String encryptedClassname) {
        try (FileOutputStream fos = new FileOutputStream( encryptedClassname )) {
            fos.write( buffer, 0, buffer.length );
        } catch (IOException ex) {
            System.out.println( ex.getMessage() );
        }
        System.out.println( "The file has been written" );
    }

    @Before
    public void encryptingClass() {
        byte[] result = readClass( Paths.get( classDir + inputClassName + ".class" ).toAbsolutePath().toString() );

        for (int i = 0; i < result.length; i++) {
            result[i] -= Byte.valueOf( key );
        }

        writeClass( result, Paths.get( classDir + ".." + File.separatorChar + inputClassName + ".class" ).toAbsolutePath().toString() );
    }

    @Test
    public void loadClass() {
        ITestClass testClass = encryptedClassloader.load(  inputClassName );
        if (!testClass.equals( null ))
            testClass.testFunc();
    }
}