package by.wadikk.core.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JsonParser<T> implements Parser<T> {

    @Value("${datasource.file.directory}")
    private String fileDirectory;

    @SneakyThrows
    @Override
    public void write(Class clazz, List<T> list) {
        String fileName = clazz.getSimpleName() + ".json";

        // TODO: 21.08.2021 заглушка
        fileDirectory = "d:/temp/xml/";

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(fileDirectory + fileName), list);

        log.info("List has been loaded to {}", fileDirectory + fileName);

    }

    @Override
    public List<T> read(Class clazz) {
        String fileName = clazz.getSimpleName() + ".json";

        ObjectMapper mapper = new ObjectMapper();
        List<T> decoded = null;
        try {
            //decoded = (List<T>) Arrays.asList(mapper.readValue(Paths.get(fileDirectory + fileName).toFile(), clazz));

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
