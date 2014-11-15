package at.berndfarka.gradle.sshscp

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.junit.Assert
import org.junit.Test
import java.util.Properties

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertNotNull

/**
 * Created by berndfarka on 15.11.14.
 */
public class SshScpPluginTest {

    @Test
    public void testPluginRegistration(){
        InputStream propertiesFileStream = ClassLoader.systemClassLoader.getResourceAsStream("META-INF/gradle-plugins/at.berndfarka.sshscp.properties")
        assertNotNull(propertiesFileStream);

        Properties prop = new Properties()
        prop.load(propertiesFileStream);
        String implClass = prop.getProperty("implementation-class");

        Class<Plugin> pluginClass = Class.forName(implClass);
        Plugin<Project> sshScpPlugin = pluginClass.newInstance();
        assertNotNull(sshScpPlugin);
        Assert.assertTrue(sshScpPlugin instanceof SshScpPlugin);

    }

}
