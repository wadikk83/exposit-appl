package by.wadikk.loader.threads;

import by.wadikk.core.parser.Parser;
import by.wadikk.loader.model.ArticleModel;
import by.wadikk.persistence.dto.ArticleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.util.file.FilenameUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ProducerThread implements Runnable {

    private final BlockingQueue<ArticleDto> queue;
    private final String path;
    private final Parser<ArticleDto> parser;

    public ProducerThread(BlockingQueue<ArticleDto> queue, String path, Parser<ArticleDto> parser) {
        this.queue = queue;
        this.path = path;
        this.parser = parser;
    }

    public void run() {
        log.info("Producer thread start");

        String pathWithoutExt = FilenameUtils.removeExtension(path);
        List<ArticleDto> decodedList = parser.read(pathWithoutExt);
        List<ArticleDto> decodedListAfterConvert = new ObjectMapper().convertValue(decodedList, new TypeReference<List<ArticleDto>>() {
        });

        queue.addAll(decodedListAfterConvert);
        new File(path).renameTo(new File(path + ".processed"));
        log.info("a list with values {} has been added to the queue in {}", decodedList, LocalDateTime.now());
        log.info("Producer thread stop");
    }
}
