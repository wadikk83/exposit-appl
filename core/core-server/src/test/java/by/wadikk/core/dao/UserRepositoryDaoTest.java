package by.wadikk.core.dao;

import by.wadikk.persistence.mapper.JsonParser;
import by.wadikk.persistence.mapper.Parser;
import by.wadikk.persistence.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserRepositoryDaoTest {

    @Test
    void abstractTest() {
        User user1 = new User("user1", "user1", "user1full", "user1@qqq.by", "user1adress");
        User user2 = new User("user2", "user2", "user2full", "user2@qqq.by", "user2adress");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        //Parser<User> parser = new ParserFactory().getParser();
        Parser<User> parser = new JsonParser<>();
        parser.write("UserRepositoryDao", userList);

        /*UserRepositoryDao userDao = new UserRepositoryDao();
        List<User> list1 = userDao.getAll();
        System.out.println(userDao.getAll());*/

    }

}