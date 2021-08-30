package by.wadikk.loader.threads;

import by.wadikk.core.service.ArticleService;
import by.wadikk.persistence.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class ConsumerThread implements Runnable {

    private final BlockingQueue<ArticleDto> queue;
    private final ArticleService service;

    public ConsumerThread(BlockingQueue<ArticleDto> queue, ArticleService service) {
        this.queue = queue;
        this.service = service;
    }

    @Override
    public void run() {
        log.info("Consumer thread start");
        while (!queue.isEmpty()) {
            ArticleDto model = queue.poll();
            try {
                service.save(model);
            } catch (Exception e) {
                log.error(e.toString(), e);
                continue;
            }
            log.info("A model {} from the queue was added", model);
        }
        log.info("Consumer thread stop");
    }
}
