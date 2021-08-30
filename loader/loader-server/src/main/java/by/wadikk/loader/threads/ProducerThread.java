package by.wadikk.loader.threads;

import by.wadikk.core.parser.FileManager;
import by.wadikk.core.parser.FileManagerImpl;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.StoreService;
import by.wadikk.persistence.dto.ArticleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ProducerThread implements Runnable {

    private BlockingQueue<ArticleDto> queue;
    private final String path;

    private FileManager fileManager = new FileManagerImpl();

    public ProducerThread(BlockingQueue<ArticleDto> queue, String path) {
        this.queue = queue;
        this.path = path;
    }

    public void run() {
        log.info("Producer thread start");

        ObjectMapper mapper = new ObjectMapper();
        List<ArticleDto> decodedList = null;
        try {
            decodedList = mapper.readValue(
                    new File(path),
                    new TypeReference<List<ArticleDto>>() {
                    });
        } catch (IOException e) {
            log.error("was not loaded from {}", path);
        }
        queue.addAll(decodedList);
        log.info("a list with values {} has been added to the queue in {}", decodedList, LocalDateTime.now());
        log.info("Producer thread stop");
    }
}
