package sk.kasv.degro.Hibernate.Repository.WorkoutData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
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
}
