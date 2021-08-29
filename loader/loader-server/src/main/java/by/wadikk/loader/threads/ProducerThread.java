package by.wadikk.loader.threads;

import by.wadikk.core.parser.FileManager;
import by.wadikk.core.parser.FileManagerImpl;
import by.wadikk.core.parser.Parser;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.StoreService;
import by.wadikk.persistence.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ProducerThread implements Runnable {

    @Autowired
    private ProductService productService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private StoreService storeService;


    private BlockingQueue<ArticleDto> queue;
    private final String path;

    private FileManager fileManager = new FileManagerImpl();


    public ProducerThread(BlockingQueue<ArticleDto> queue, String path) {
        this.queue = queue;
        this.path = path;
    }

    public void run() {
        log.info("Producer thread start");

        Parser<ArticleDto> parser = fileManager.getHandler(path);
        List<ArticleDto> articleList =
                parser.read(path.substring(0, path.lastIndexOf('.')));

        queue.addAll(articleList);

        log.info("Producer thread stop");
    }
}
