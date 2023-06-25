package de.ait.services.UserService;


import de.ait.models.User;
import de.ait.repositories.fakeImpl.UsersRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserServiceImpl(new UsersRepositoryFakeImpl());

    }

    @Test
    void getUser() {
        List<User> userList = userService.getUser();

        assertEquals(2, userList.size());
        assertEquals("First name1", userList.get(0).getFirstName());
        assertEquals("Last name2", userList.get(1).getLastName());
        assertEquals("1.@mail.com", userList.get(0).getEmail());

    }
}