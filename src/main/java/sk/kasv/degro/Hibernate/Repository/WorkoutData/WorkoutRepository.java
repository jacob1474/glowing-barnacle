package sk.kasv.degro.Hibernate.Repository.WorkoutData;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import sk.kasv.degro.Hibernate.Database.Entity.UserWorkout;
import sk.kasv.degro.Hibernate.Database.Entity.Workout;

@Repository
public class WorkoutRepository implements IWorkoutRepository {
    private EntityManager entityManager;

    @Autowired
    public WorkoutRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return entityManager.createQuery("SELECT w FROM Workout w", Workout.class).getResultList();
    }

    @Override
    public List<Workout> getWorkoutsByCategoryId(int categoryId) {
        return entityManager.createQuery("SELECT w FROM Workout w WHERE w.category.id = :categoryId", Workout.class)
                .setParameter("categoryId", categoryId).getResultList();
    }

    @Override
    public List<UserWorkout> getWorkoutsByUserId(int userId) {
        List<UserWorkout> workouts = entityManager.createQuery("SELECT w FROM UserWorkout w WHERE w.user.id = :userId", UserWorkout.class)
                .setParameter("userId", userId)
                .getResultList();

        workouts.forEach(workout -> {
            workout.setDate(LocalDate.parse(workout.getDate().toString())); // Ensure correct format
        });

        return workouts;
    }
}
