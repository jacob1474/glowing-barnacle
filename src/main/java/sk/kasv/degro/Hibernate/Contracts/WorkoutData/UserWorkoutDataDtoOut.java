package sk.kasv.degro.Hibernate.Contracts.WorkoutData;

import sk.kasv.degro.Hibernate.Contracts.UserData.UserDataDtoOut;

public class UserWorkoutDataDtoOut extends WorkoutDataDtoOut {
    public String date;
    public int duration;
    public UserDataDtoOut user;
    public WorkoutDataDtoOut workout;
}
