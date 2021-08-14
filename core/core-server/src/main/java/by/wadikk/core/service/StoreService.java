package by.wadikk.core.service;

import by.wadikk.core.model.Store;

import java.util.List;

public interface StoreService {

    boolean create(Store store);

    List<Store> readAll();

    Store read(long id);

    boolean update(Store store, long id);

    boolean delete(long id);
}
