import Net.Downloader;
import utils.PathParser;

import java.io.*;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File( Paths.get( "" ).toAbsolutePath() + "\\src\\main\\resources\\LinksFiles.txt" );

            FileReader fr = new FileReader( file );

            BufferedReader reader = new BufferedReader( fr );

            ExecutorService service = Executors.newFixedThreadPool( 2 );


            String line = reader.readLine();
            List<Future> listFuture = new ArrayList<>();
            while (line != null) {
                final String finalLine = line;
                Optional<String> fileName = PathParser.getFileName(line);
                Runnable task = () -> {
                    try {
                        Downloader.downloadFileFromUrlWithJavaIO( fileName.get(), finalLine );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                listFuture.add( service.submit( task ) );
                line = reader.readLine();
            }

            for (Future future:listFuture) {
                future.get();
            }


            service.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}