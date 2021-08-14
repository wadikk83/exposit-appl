package by.wadikk.core.service;

import by.wadikk.core.model.Category;

import java.util.List;

public interface CategoryService {

    boolean create(Category category);

    List<Category> readAll();

    Category read(long id);

    boolean update(Category category, long id);

    boolean delete(long id);
}
