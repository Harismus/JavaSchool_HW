package zip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipService {
    Path dirCache;
    public ZipService(Path dirCache) {
        this.dirCache = dirCache;
    }

    public void zip(String file, String fileZip) {

        try {
            File f = new File(dirCache +  fileZip );
            ZipOutputStream out = new ZipOutputStream( new FileOutputStream( f ) );

            ZipEntry e = new ZipEntry( file );
            out.putNextEntry( e );

            File fileClass = new File(dirCache + file);
            Files.copy(fileClass.toPath(), out);

            out.closeEntry();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
