
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;

import javax.security.auth.login.LoginException;

public class Init {

    public static JDA jda;
    public static void main(String[] args)
            throws LoginException, InterruptedException {
        Settings.loadSettings();
        JDABuilder builder = new JDABuilder(AccountType.BOT).setToken(Settings.getToken());


        builder.addEventListener(new Pinbot());


        jda = builder.buildBlocking();

    }




}
