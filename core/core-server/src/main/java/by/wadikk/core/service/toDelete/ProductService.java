package by.wadikk.core.service.toDelete;

public interface ProductService {

    /**
     * Создает новый продукт
     *
     * @param product - продукт для создания
     *//*
    boolean create(Product product);

    *//**
     * Возвращает список всех имеющихся продуктов
     *
     * @return список продуктов
     *//*
    List<Product> readAll();

    *//**
     * Возвращает продукт по его ID
     *
     * @param id - ID продукта
     * @return - объект продукта с заданным ID
     *//*
    Product read(long id);

    *//**
     * Обновляет продукт с заданным ID,
     * в соответствии с переданным продуктом
     *
     * @param product - продукт в соответсвии с которым нужно обновить данные
     * @param id      - id продукта которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     *//*
    boolean update(Product product, long id);

    *//**
     * Удаляет продукт с заданным ID
     *
     * @param id - id продукта, которого нужно удалить
     * @return - true если продукт был удален, иначе false
     *//*
    boolean delete(long id);

    *//**
     * Ищет продукт по заданному атрибуту продукта
     *
     * @param attributeId -id атрибута
     * @return - список продуктов
     *//*
    List<Product> findByAttributes(Long attributeId);

    *//**
     * Ищет продукт по заданному атрибуту продукта
     *
     * @param CategoryId -id атрибута
     * @return - список продуктов
     *//*
    List<Product> findByCategory(Long CategoryId);

    *//**
     * Возвращает список всех имеющихся продуктов в магазине
     *
     * @param storeId - id магазина
     * @return - список продуктов в магазине
     *//*
    List<Product> getAllByStoreId(Long storeId);*/

}
