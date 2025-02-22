package sk.kasv.degro.Hibernate.Services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.kasv.degro.Hibernate.Common.Mapper;
import sk.kasv.degro.Hibernate.Contracts.CategoryData.CategoryDataDtoOut;
import sk.kasv.degro.Hibernate.Database.Entity.Category;
import sk.kasv.degro.Hibernate.Repository.CategoryData.CategoryReposiotry;

@Service
public class CategoryService {
    private final CategoryReposiotry categoryRepository;
    private final Mapper mapper;

    @Autowired
    public CategoryService(CategoryReposiotry categoryReposiotory, Mapper mapper) {
        this.categoryRepository = categoryReposiotory;
        this.mapper = mapper;
    }

    public List<CategoryDataDtoOut> getAllCategories() {
        List<Category> categories = categoryRepository.getAllCategories();
        List<CategoryDataDtoOut> categoryData = mapper.ToCategoryDataDtoOut(categories);

        return categoryData;
    }
}
