package parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties prop;

    public PropertiesReader() {
        prop = new Properties();
        try {
            // Load the properties file
            FileInputStream fis = new FileInputStream("C:\\Users\\PAVILAA\\Downloads\\abhibus\\src\\test\\resource\\propertiesfile\\driverrepository.properties");
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Chrome driver name (from config.properties)
    public String getChromeDriverName() {
        return prop.getProperty("chromeDriverName");
    }

    // Get Chrome driver path (from config.properties)
    public String getChromeDriverPath() {
        return prop.getProperty("chromeDriverPath");
    }

    // Get Edge driver name (from config.properties)
    public String getEdgeDriverName() {
        return prop.getProperty("edgeDriverName");
    }

    // Get Edge driver path (from config.properties)
    public String getEdgeDriverPath() {
        return prop.getProperty("edgeDriverPath");
    }

    // Get the main URL (from config.properties)
    public String getMainURL() {
        return prop.getProperty("mainURL");
    }
}
