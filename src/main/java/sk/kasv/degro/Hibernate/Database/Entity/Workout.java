package sk.kasv.degro.Hibernate.Database.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_workout_category"))
    private Category category;

    public Workout() {
    }

    public Workout(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Workout [id=" + id + ", name=" + name + ", description=" + description + ", category=" + (category != null ? category.getName() : "None") + "]";
    }
}
