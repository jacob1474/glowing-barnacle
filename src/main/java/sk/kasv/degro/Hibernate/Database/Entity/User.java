package sk.kasv.degro.Hibernate.Database.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "weight")
    private double weight;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", weight=" + weight + "]";
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public User(String name, String email, int age, double weight) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
    }
}
