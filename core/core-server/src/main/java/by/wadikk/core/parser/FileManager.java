package by.wadikk.core.parser;

public interface FileManager {

    String getExtension(String fileName);

    public Parser getHandler(String fileName);
}
