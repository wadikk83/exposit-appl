package by.wadikk.core.mapper;


import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

@Slf4j
public class XmlParser<T> implements Parser<T> {

    @Value("${datasource.file.directory}")
    private String fileDirectory;

    @SneakyThrows
    public void write(@NonNull Class clazz, List<T> list) {
        String fileName = clazz.getSimpleName() + ".xml";

        // TODO: 21.08.2021 заглушка

        fileDirectory = "d:/temp/xml/";

        final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(fileDirectory + fileName)));
        encoder.writeObject(list);
        encoder.close();
        log.info("List has been loaded to {}", fileDirectory + fileName);
    }

    public List<T> read(@NonNull Class clazz) {
        String fileName = clazz.getSimpleName() + ".xml";

        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(
                    new FileInputStream(fileDirectory + fileName)));
        } catch (FileNotFoundException e) {
            log.error("was not loaded from {}", fileDirectory + fileName);
        }
        List<T> decoded = (List<T>) decoder.readObject();
        decoder.close();
        log.info("List has been loaded from {}", fileDirectory + fileName);
        return decoded;
    }
}
