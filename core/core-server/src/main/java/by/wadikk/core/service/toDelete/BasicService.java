package by.wadikk.core.service.toDelete;


public interface BasicService<T, ID> {
   /* *//**
     * Creates a new entity
     *
     * @param entity - entity to create
     * @return
     *//*
    UserEntity create(T entity);

    *//**
     * Returns a list of all available entities
     *
     * @return list of entities
     *//*
    List<T> readAll();

    *//**
     * Returns an entity by its ID
     *
     * @param id - entity id
     * @return - entity object with the given ID
     *//*
    Optional<T> findById(ID id);

    *//**
     * Updates the entity with the given ID according to the passed entity
     *
     * @param entity - the entity according to which you want to update the data
     * @param id       - id of the entity to update
     * @return -
     * true if the data has been updated, otherwise false
     *//*
    T update(T entity, ID id);

    *//**
     * Removes an entity with the given ID
     *
     * @param id - ID of the entity to be deleted
     * @return - true if the entity was deleted, otherwise false
     *//*
    boolean delete(ID id);*/
}
