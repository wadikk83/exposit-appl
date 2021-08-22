package by.wadikk.persistence.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
public class JsonParser<T> implements Parser<T> {

    @Value("${datasource.file.directory}")
    private String fileDirectory;

    @SneakyThrows
    @Override
    public void write(String className, List<T> list) {
        String fileName = className + ".json";

        // TODO: 21.08.2021 заглушка
        //fileDirectory = "d:/temp/json/";

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(fileDirectory + fileName), list);

        log.info("List has been loaded to {}", fileDirectory + fileName);

    }

    @Override
    public List<T> read(String className) {
        String fileName = className + ".json";

        ObjectMapper mapper = new ObjectMapper();
        List<T> decoded = null;
        try {
            decoded = mapper.readValue(
                    new File(fileDirectory + fileName),
                    new TypeReference<List<T>>() {
                    });
        } catch (IOException e) {
            log.error("was not loaded from {}", fileDirectory + fileName);
        }
        log.info("List has been loaded from {}", fileDirectory + fileName);
        return decoded;
    }
}
