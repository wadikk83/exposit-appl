package by.wadikk.loader.service;

import by.wadikk.core.parser.FileManager;
import by.wadikk.core.parser.FileManagerImpl;
import by.wadikk.core.service.ProductService;
import by.wadikk.loader.model.ListSchedule;
import by.wadikk.loader.model.Schedule;
import by.wadikk.loader.threads.ConsumerThread;
import by.wadikk.loader.threads.ProducerThread;
import by.wadikk.persistence.dto.ArticleDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ScheduledTasks {

    @Autowired
    private ProductService productService;

    private FileManager fileManager = new FileManagerImpl();

    private final ListSchedule listSchedule;

    private BlockingQueue<ArticleDto> queue = new LinkedBlockingQueue<>();
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    public ScheduledTasks(ListSchedule listSchedule) {
        this.listSchedule = listSchedule;
    }

    @SneakyThrows
    @PostConstruct
    public void run() {

        for (Schedule schedule : listSchedule.getListSchedule()) {

            Path path = Paths.get(schedule.getDirectory());
            if (!Files.exists(path)) {
                log.info("Directory {} not found", path);
                continue;
            }

            List<File> filesInFolder = Files.walk(Paths.get(schedule.getDirectory()))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());

            if (filesInFolder.isEmpty()) {
                log.info("Folder {} is empty", schedule.getDirectory());
                continue;
            }

            for (File file : filesInFolder) {
                long timeDelay = schedule.getTime().getSecond() - System.currentTimeMillis();

                executorService.schedule(
                        new ProducerThread(queue, file.getAbsolutePath()), 5, TimeUnit.SECONDS);

               /* executorService.scheduleAtFixedRate(
                        new ProducerThread(queue, file.getAbsolutePath()), 100, 60, TimeUnit.SECONDS);*/

                executorService.schedule(
                        new ConsumerThread(queue), 10, TimeUnit.SECONDS);

                /*executorService.scheduleAtFixedRate(
                        new ConsumerThread(queue), 30, 60, TimeUnit.SECONDS);*/

                //new ConsumerThread(queue).run();
            }
        }
        //executorService.shutdown();
    }
}
