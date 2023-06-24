package de.ait.repositories.fakeImpl;

import de.ait.models.GenreOfMusic;
import de.ait.models.Music;
import de.ait.models.Product;
import de.ait.models.User;
import de.ait.repositories.users.UsersRepository;

import java.util.List;

public class UsersRepositoryFakeImpl implements UsersRepository {
    @Override
    public User findByTitle(String title) {
        return null;
    }

    @Override
    public List<User> findAll() {
        User user1 = new User("First name1","Last name1","1.@mail.com");
        User user2 = new User("First name2","Last name2","2.@mail.com");
        List<User> users= List.of(user1,user2);
        return users;

    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
