import org.junit.Test;

import java.nio.file.Paths;

interface Expression {
    Plugin getPlugin(String rootDir, String pluginDir, String namePluginClass);
}

public class PluginManagerTest {

    @Test
    public void testLoad() {
        Expression func = (String rootDir, String pluginDir, String namePluginClass) -> {
            PluginManager loader = new PluginManager( Paths.get( rootDir ).toAbsolutePath().toString() );
            Plugin plugin = loader.load( pluginDir, namePluginClass );
            return plugin;
        };


        Plugin firstPlugin = func.getPlugin( "", "MyPlugins", "FirstPlugin" );
        if (!firstPlugin.equals( null ))
            firstPlugin.doUsefull();

        Plugin secondPlugin = func.getPlugin( "", "MyPlugins", "SecondPlugin" );
        if (!secondPlugin.equals( null ))
            secondPlugin.doUsefull();

    }
}