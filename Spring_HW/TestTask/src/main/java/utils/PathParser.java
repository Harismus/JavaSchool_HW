package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PathParser {
    public static   Optional<String> getFileName(String path) {

        Optional<String> lastString = Optional.ofNullable( Arrays.stream( path.split( "/" ) ).reduce( (e1, e2) -> e2 )
                .orElse( null ) );

        System.out.println( "text = " + lastString );
        return lastString;
    }
}
