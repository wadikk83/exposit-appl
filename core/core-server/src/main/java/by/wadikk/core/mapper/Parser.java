package by.wadikk.core.mapper;

import java.util.List;

public interface Parser<T> {

    void write(String className, List<T> list);

    List<T> read(String className);

}
