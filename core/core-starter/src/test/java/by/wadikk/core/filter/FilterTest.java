package by.wadikk.core.filter;

import by.wadikk.core.repository.repositoryJPA.UserRepositoryJpa;
import by.wadikk.persistence.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Import(CoreConfiguration.class)
class FilterTest {

    @Autowired
    UserRepositoryJpa repository;

    @BeforeEach
    public void prepare() {
        User user1 = new User();
        user1.setLogin("user1");
        user1.setAddress("address1");
        user1.setEmail("1@tut.by");
        user1.setPassword("111");
        user1.setFullName("username1");

        User user2 = new User();
        user2.setLogin("user2");
        user2.setAddress("address1");
        user2.setEmail("2@tut.by");
        user2.setPassword("222");
        user2.setFullName("username2");

        User user3 = new User();
        user3.setLogin("user3");
        user3.setAddress("address3");
        user3.setEmail("3@tut.by");
        user3.setPassword("333");
        user3.setFullName("username3");

        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
    }

    /*@Test
    public void retrieveUserByFilter() {

        Filter filter = new Filter();
        filter.addCondition(new Condition.Builder()
                .setComparison(Comparison.equal)
                .setField("address")
                .setValue("address1").build());


//        List<User> userList = repository.findAll(filter);
//        Assertions.assertEquals(userList.get(0).getAddress(), "address1");
//        assertThat(carList.isEmpty(), is(false));
//        assertEquals(carList.get(0).brand, "volkswagen");
    }*/

}