package sk.kasv.degro.Hibernate.Repository.UserData;

import java.util.List;

import sk.kasv.degro.Hibernate.Database.Entity.User;

public interface IUserRepository {
    User getUserById(int id);
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user, int id);
}
