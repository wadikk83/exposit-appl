package by.wadikk.core.parser;

import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.core.exception.FileFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:persistence.properties")
@Component
public class ParserFactory {

//    @Value("${datasource.file.format}")
//    private String fileFormatParser ;

    private String fileFormatParser = PersistenceConfiguration.datasourceFileFormat;

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
