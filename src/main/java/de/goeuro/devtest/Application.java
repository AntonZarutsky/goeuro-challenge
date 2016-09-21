package de.goeuro.devtest;

import de.goeuro.devtest.service.MainService;
import de.goeuro.devtest.util.ProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Application entry point. For simplicity we are collecting all Spring and App related stuff here (which includes Main
 * function, Command line runner, Spring configuration, etc). In real world's app it is highly recommended to split this
 * into separate classes.
 */
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    public MainService mainService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .run(args);
    }

    @Override
    public void run(String[] args) throws Exception {
        if (args.length != 1) {
            log.error("Parameters are incorrect. Expected exactly 1 parameter.");
            return;
        }

        try {
            final String cityName = args[0].trim();
            mainService.suggest(cityName);

        } catch (ProcessingException e) {
            log.error(e.getMessage());
        } catch (RuntimeException e) {
//            more detailed logs, if deeper investigation needed.
            log.error("Error during application execution", e);
        }
    }
}
