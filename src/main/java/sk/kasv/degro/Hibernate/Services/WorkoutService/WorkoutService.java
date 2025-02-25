package sk.kasv.degro.Hibernate.Services.WorkoutService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.kasv.degro.Hibernate.Common.Mapper;
import sk.kasv.degro.Hibernate.Contracts.WorkoutData.UserWorkoutDataDtoOut;
import sk.kasv.degro.Hibernate.Contracts.WorkoutData.WorkoutDataDtoOut;
import sk.kasv.degro.Hibernate.Database.Entity.User;
import sk.kasv.degro.Hibernate.Database.Entity.UserWorkout;
import sk.kasv.degro.Hibernate.Database.Entity.Workout;
import sk.kasv.degro.Hibernate.Repository.UserData.UserRepository;
import sk.kasv.degro.Hibernate.Repository.WorkoutData.WorkoutRepository;

@Service
public class WorkoutService implements IWorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository, Mapper mapper) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<WorkoutDataDtoOut> getAllWorkouts() {
        List<Workout> workouts = workoutRepository.getAllWorkouts();
        List<WorkoutDataDtoOut> workoutData = mapper.ToWorkoutDataDtoOut(workouts);

        return workoutData;
    }

    @Override
    public List<WorkoutDataDtoOut> getWorkoutsByCategoryId(int categoryId) {
        List<Workout> workouts = workoutRepository.getWorkoutsByCategoryId(categoryId);
        List<WorkoutDataDtoOut> workoutData = mapper.ToWorkoutDataDtoOut(workouts);

        return workoutData;
    }

    @Override
    public List<UserWorkoutDataDtoOut> getWorkoutsByUserId(int userId) {
        User user = userRepository.getUserById(userId);
        List<UserWorkout> workouts = workoutRepository.getWorkoutsByUserId(userId);

        List<UserWorkoutDataDtoOut> workoutData = mapper.ToUserWorkoutDataDtoOut(user, workouts);

        return workoutData;
    }
}
