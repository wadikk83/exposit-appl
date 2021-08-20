package by.wadikk.core.service.impl;

class UserServiceImplTest {

    /*private UserService userService;

    @MockBean
    UserRepository userRepositoryMock;

    @Before
    public void setUp() {
        System.out.println("Code executes before each test method");
        UserEntity user1 = new UserEntity("user1","user1","user1full","user1@qqq.by","user1adress");
        UserEntity user2 = new UserEntity("user2","user2","user2full","user2@qqq.by","user2adress");

        List<UserEntity> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        userService = new UserServiceImpl(userRepositoryMock);
    }

    @Test
    public void getAllUsersTest(){

        List<UserEntity> usersFromMock=new ArrayList<>();

        Mockito.doReturn(usersFromMock).when(userRepositoryMock.findAll());

        List<UserEntity> users = userService.readAll();

        Assert.assertEquals(users,usersFromMock);
    }*/

}