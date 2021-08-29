package by.wadikk.core.parser;

import by.wadikk.core.exception.NoHandlerException;

public class FileManagerImpl implements FileManager {
    @Override
    public String getExtension(String fileName) {

        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    @Override
    public Parser getHandler(String fileName) {

        String fileExtension = getExtension(fileName);

        switch (fileExtension) {
            case "xml":
                return new XmlParser();

            case "json":
                return new JsonParser();

            default: {
                throw createNoHandlerException(fileName);
            }
        }
    }

    private NoHandlerException createNoHandlerException(String fileName) {
        return new NoHandlerException(
                String.format("Mapper not assigned for file {}", fileName));
    }
}
