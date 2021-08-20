package by.wadikk.core.mapper;

import java.util.List;

public interface Parser<T> {

    void write(Class clazz, List<T> list);

    List<T> read(Class clazz);
}
