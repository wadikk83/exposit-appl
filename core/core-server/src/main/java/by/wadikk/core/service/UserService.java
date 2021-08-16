package by.wadikk.core.service;

import by.wadikk.core.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    /**
     * Создает нового клиента
     * @param user - клиент для создания
     */
    boolean create(User user);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<User> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Optional<User> findById(long id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    User update(User client, long id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(long id);
}
