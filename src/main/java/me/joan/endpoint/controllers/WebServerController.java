package me.joan.endpoint.controllers;

import me.joan.endpoint.WebServer;
import me.joan.internal.Client;
import me.joan.internal.ThreadFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@RestController
public class WebServerController {
    static Client client = new Client("localhost", 12345);

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor(ThreadFactory.withName("dispatcher")::create);

    @GetMapping("/")
    public String blank() {
        executor.execute(client);
        return "Hello, World! "+ WebServer.random.nextInt();
    }
}
