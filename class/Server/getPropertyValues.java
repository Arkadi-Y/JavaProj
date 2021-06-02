package Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import Interfaces.*;
import java.util.Properties;

public class getPropertyValues implements getPropertyValuesInt {
    String[] result = new String[3];
    InputStream inputStream;

    public String[] getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "data.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            // get the property value and print it out
            result[0] = prop.getProperty("sqlUrl");
            result[1] = prop.getProperty("user");
            result[2] = prop.getProperty("password");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
        return result;
    }
}
