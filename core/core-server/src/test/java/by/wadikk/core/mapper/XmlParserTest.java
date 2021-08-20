package by.wadikk.core.mapper;

import by.wadikk.persistence.entities.User;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

class XmlParserTest {

    @org.junit.jupiter.api.Test
    void write() {

        User user1 = new User("user1", "user1", "user1full", "user1@qqq.by", "user1adress");
        User user2 = new User("user2", "user2", "user2full", "user2@qqq.by", "user2adress");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        //Parser<User> parser = new ParserFactory().getParser();
        Parser<User> parser = new XmlParser<>();
        parser.write(User.class, userList);

        List<User> userListUp = parser.read(User.class);

        Assert.notEmpty(userListUp);
    }
}