package sk.kasv.degro.Hibernate.Repository.WorkoutData;

import java.util.List;

import sk.kasv.degro.Hibernate.Database.Entity.Workout;


public interface IWorkoutRepository {
    List<Workout> getAllWorkouts();
    List<Workout> getWorkoutsByCategoryId(int categoryId);
}
