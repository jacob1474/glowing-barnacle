package sk.kasv.degro.Hibernate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import sk.kasv.degro.Hibernate.Contracts.UserData.UserDataDtoIn;
import sk.kasv.degro.Hibernate.Contracts.UserData.UserDataDtoOut;
import sk.kasv.degro.Hibernate.Services.UserService.UserService;

@RestController
public class UserDataController {

    private final UserService userService;

    @Autowired
    public UserDataController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers() {
        return Json.pretty(userService.getAllUsers());
    }

    @Operation(summary = "Save a new user to the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public UserDataDtoOut saveUser(@RequestBody UserDataDtoIn userData) {
        UserDataDtoOut userDataOut = userService.addUser(userData.toUser());

        return userDataOut;
    }

    @Operation(summary = "Update user data in the database by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public UserDataDtoOut updateUser(@PathVariable int id, @RequestBody UserDataDtoIn userData) {
        UserDataDtoOut userDataOut = userService.updateUser(userData.toUser(), id);

        return userDataOut;
    }
}

