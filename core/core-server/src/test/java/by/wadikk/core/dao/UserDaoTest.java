package by.wadikk.core.dao;

import by.wadikk.core.mapper.JsonParser;
import by.wadikk.core.mapper.Parser;
import by.wadikk.persistence.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

class UserDaoTest {

    @Test
    void abstractTest() {
        User user1 = new User("user1", "user1", "user1full", "user1@qqq.by", "user1adress");
        User user2 = new User("user2", "user2", "user2full", "user2@qqq.by", "user2adress");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        //Parser<User> parser = new ParserFactory().getParser();
        Parser<User> parser = new JsonParser<>();
        parser.write("UserDao", userList);

        /*UserDao userDao = new UserDao();
        List<User> list1 = userDao.getAll();
        System.out.println(userDao.getAll());*/

    }

}