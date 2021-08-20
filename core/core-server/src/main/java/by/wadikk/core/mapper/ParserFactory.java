package by.wadikk.core.mapper;

import by.wadikk.core.exception.FileFormatException;
import org.springframework.beans.factory.annotation.Value;

public class ParserFactory {

    @Value("${datasource.file.format}")
    private String fileFormatParser;

    public Parser getParser() {

        switch (fileFormatParser) {
            case "XML":
                return new XmlParser();
            case "JSON":
                return new JsonParser();
            default:
                new FileFormatException("File format is not supported");
        }
        return null;
    }
}
