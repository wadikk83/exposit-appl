package by.wadikk.persistence.mapper;

import by.wadikk.persistence.PersistenceConfiguration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import groovy.beans.PropertyReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Slf4j
@Component
public class JsonParser<T> implements Parser<T> {

    private String fileDirectory = PersistenceConfiguration.fileDirectory;

//    @PostConstruct
//    public void initialise() {
//        fileDirectory = PersistenceConfiguration.fileDirectory;
//    }

    @SneakyThrows
    @Override
    public void write(String className, List<T> list) {
        String fileName = className + ".json";
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
            return null;
        }
        log.info("List has been loaded from {}", fileDirectory + fileName);
        return decoded;
    }
}
