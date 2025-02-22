package sk.kasv.degro.Hibernate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import sk.kasv.degro.Hibernate.Services.CategoryService.CategoryService;

@RestController
public class CategoryDataController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryDataController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Get all categories from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful Response"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String getCategories() {
        return Json.pretty(categoryService.getAllCategories());
    }
}

