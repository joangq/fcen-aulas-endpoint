package me.joan.internal;

import me.joan.endpoint.WebServer;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client implements Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    private final Random random = new Random();
    private final String host;
    private final int port;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        sendSignal(WebServer.random.nextInt(127+1));
    }

    private void sendSignal(int data) {
        LOGGER.info("Connecting to "+this.host+":"+this.port+" ...");
        try (Socket socket = new Socket(this.host, this.port)){
            LOGGER.info("Opening stream...");
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            outputStream.write(data);
            LOGGER.info("Wrote '"+ data +"' to the stream.");
            byte x = inputStream.readNBytes(1)[0];
            LOGGER.info(String.format("Acknowledged '0x%x'.", x));
            outputStream.close();
            LOGGER.info("Stream closed.");
        } catch (Exception e) {
            LOGGER.warn("Couldn't connect to "+this.host+":"+this.port+". "+e.getMessage());
        }
    }
}
