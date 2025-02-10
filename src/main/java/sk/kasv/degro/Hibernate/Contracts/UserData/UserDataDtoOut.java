package sk.kasv.degro.Hibernate.Contracts.UserData;

import sk.kasv.degro.Hibernate.Database.Entity.User;

public class UserDataDtoOut {
    public String name;
    public String email;
    public int age;
    public double weight;

    public UserDataDtoOut(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.weight = user.getWeight();
    }
}
