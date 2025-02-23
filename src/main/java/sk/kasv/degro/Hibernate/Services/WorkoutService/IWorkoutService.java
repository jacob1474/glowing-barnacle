package sk.kasv.degro.Hibernate.Services.WorkoutService;

import java.util.List;

import sk.kasv.degro.Hibernate.Contracts.WorkoutData.WorkoutDataDtoOut;

public interface IWorkoutService {
    List<WorkoutDataDtoOut> getAllWorkouts();
    List<WorkoutDataDtoOut> getWorkoutsByCategoryId(int categoryId);
}
