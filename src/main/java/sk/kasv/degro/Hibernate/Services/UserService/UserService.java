package sk.kasv.degro.Hibernate.Services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.kasv.degro.Hibernate.Common.Mapper;
import sk.kasv.degro.Hibernate.Contracts.UserData.UserDataDtoOut;
import sk.kasv.degro.Hibernate.Database.Entity.User;
import sk.kasv.degro.Hibernate.Repository.UserData.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserDataDtoOut> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        List<UserDataDtoOut> userData = mapper.ToUserDataDtoOut(users);

        return userData;
    }

    public UserDataDtoOut addUser(User user) {
        User userData = userRepository.addUser(user);

        return mapper.ToUserDataDtoOut(userData);
    }

    public UserDataDtoOut updateUser(User user, int id) {
        User userData = userRepository.updateUser(user, id);

        return mapper.ToUserDataDtoOut(userData);
    }
}
