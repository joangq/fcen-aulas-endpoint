package me.joan.endpoint;

import me.joan.internal.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class WebServer {
    static final Logger LOGGER = LoggerFactory.getLogger(WebServer.class);
    static final Client client = new Client("localhost", 12345);
    public static final Random random = new Random();

    public static void main(String[] args) {
        //client.run();
        SpringApplication.run(WebServer.class, args);
    }
}
