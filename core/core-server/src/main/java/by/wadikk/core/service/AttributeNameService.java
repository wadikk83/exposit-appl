package by.wadikk.core.service;

import by.wadikk.core.model.AttributeName;

import java.util.List;

public interface AttributeNameService {
    /**
     * Создает новое имя атрибута для продукта
     * @param attributeName - атрибут для создания
     */
    boolean create(AttributeName attributeName);

    List<AttributeName> readAll();

    AttributeName read(long id);

    boolean update(AttributeName attributeName, long id);

    boolean delete(long id);
}
