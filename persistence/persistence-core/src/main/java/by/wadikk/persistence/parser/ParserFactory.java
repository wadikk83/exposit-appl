package by.wadikk.persistence.parser;

import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.exception.FileFormatException;


public class ParserFactory {

    //    @Value("${datasource.file.format}")
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
