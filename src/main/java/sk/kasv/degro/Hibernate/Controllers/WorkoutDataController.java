package sk.kasv.degro.Hibernate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import sk.kasv.degro.Hibernate.Services.WorkoutService.WorkoutService;

@RestController
public class WorkoutDataController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutDataController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @Operation(summary = "Get all workouts from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/getWorkouts", method = RequestMethod.GET)
    public String getUsers() {
        return Json.pretty(workoutService.getAllWorkouts());
    }

    @Operation(summary = "Get workouts by category id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/getWorkoutsByCategory/{categoryId}", method = RequestMethod.GET)
    public String getWorkoutsByCategory(@PathVariable int categoryId) {
        return Json.pretty(workoutService.getWorkoutsByCategoryId(categoryId));
    }
}

