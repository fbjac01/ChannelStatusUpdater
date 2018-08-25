import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Settings {

    private static String token;
    private static String roleone;
    private static String roletwo;
    private static String rolethree;
    private static String pretextone;
    private static String pretexttwo;
    private static String pretextthree;


    public static void loadSettings() {


        URL inputUrl = Settings.class.getResource("/settings.conf");
        File settingsFile = new File("settings.conf");
        if (!settingsFile.exists()) {
            try {
                FileUtils.copyURLToFile(inputUrl, settingsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Config config = ConfigFactory.parseFile(settingsFile);

        System.out.println("Loading Settings");

        token = config.getString("token");
        roleone = config.getString("roleone");
        roletwo = config.getString("roletwo");
        rolethree = config.getString("rolethree");
        pretextone = config.getString("pretextone");
        pretexttwo = config.getString("pretexttwo");
        pretextthree = config.getString("pretextthree");

    }


    public static String getToken() {
        return token;
    }

    public static String getRoleone() { //not actually used right now
        return roleone;
    }

    public static String getRoletwo() {
        return roletwo;
    }

    public static String getRolethree() {
        return rolethree;
    }

    public static String getPretextone() {
        return pretextone;
    }

    public static String getPretexttwo() {
        return pretexttwo;
    }

    public static String getPretextthree() {
        return pretextthree;

    }



}