
package edu.wgu.d387_sample_code.convertor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class WelcomeMessageImpl implements WelcomeMessageService {
    static ArrayList<String> welcomeMessages = new ArrayList<>();
    static ExecutorService messageExecutor = newFixedThreadPool(5);

    @Override
    public ArrayList<String> getWelcomeMessages() {
        System.out.println("Welcome Message CALLLLLLLLLLLLLLLLLLLLEEEEEEEEEED");

        if (welcomeMessages.isEmpty()) {
            Thread thread = new Thread(() -> {
                Properties properties = new Properties();
                messageExecutor.execute(()-> {
                    try {
                        InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                        properties.load(stream);
                        welcomeMessages.add(properties.getProperty("message"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                messageExecutor.execute(()-> {
                    try {
                        InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                        properties.load(stream);
                        welcomeMessages.add(properties.getProperty("message"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });

            thread.start();
        }

        return welcomeMessages;
    }
}
