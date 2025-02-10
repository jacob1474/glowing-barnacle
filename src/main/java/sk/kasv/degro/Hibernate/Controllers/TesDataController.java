package sk.kasv.degro.Hibernate.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TesDataController {
    @Operation(summary = "Test connection")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testConnection() {
        return "Connection is working.";
    }

    @Operation(summary = "Get greeting message")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @RequestMapping(value = "/greet", method = RequestMethod.POST)
    public String greetUser(@RequestParam String name, @RequestParam String gender) {
        return "Hello " + name + "! Your gender is " + gender + ".";
    }
}
