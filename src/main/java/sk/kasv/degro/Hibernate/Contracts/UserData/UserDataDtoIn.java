package sk.kasv.degro.Hibernate.Contracts.UserData;

import sk.kasv.degro.Hibernate.Database.Entity.User;

public class UserDataDtoIn {
    public String name;
    public String email;
    public int age;
    public double weight;

    public User toUser() {
        return new User(name, email, age, weight);
    }
}
