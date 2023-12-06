package me.joan.fcen.aulas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public String blank() {
        // TODO: Find this path instead of hard-coding it.
        String directoryPath = "./output/cache";

        Path directory = Paths.get(directoryPath);
        Path file = Paths.get(directoryPath+"/latest.txt");
        String content = "null";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                System.out.println(entry);
            }

            content = String.join("\n", Files.readAllLines(file));
            logger.info(content);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return content;
    }
}
