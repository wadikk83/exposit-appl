package by.wadikk.loader.threads;

import by.wadikk.persistence.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class ConsumerThread implements Runnable {

    private BlockingQueue<ArticleDto> queue;

    @Autowired
    private ApplicationContext context;

    public ConsumerThread(BlockingQueue<ArticleDto> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("Consumer thread start");

        log.info(queue.poll().toString());
//        private ArticleService service = context.getBean(ArticleService.class);
        /*while (!queue.isEmpty()) {
            ArticleDto model = queue.poll();
            log.info("----------------------------------------{}", model);
            *//* service.save(model);*//*
            log.info("Safe entity {} from loader", model);
        }*/


        log.info("Consumer thread stop");
    }
}
