package by.wadikk.core.service.impl;

import by.wadikk.core.model.Store;
import by.wadikk.core.repository.StoreRepository;
import by.wadikk.core.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean create(Store store) {
        if (storeRepository.findById(store.getId()) == null) {
            storeRepository.save(store);
            return true;
        }
        return false;
    }

    @Override
    public List<Store> readAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store read(long id) {
        return storeRepository.getById(id);
    }

    @Override
    public boolean update(Store store, long id) {
        if (storeRepository.getById(id) != null) {
            storeRepository.save(store);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (storeRepository.findById(id) != null) {
            storeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
