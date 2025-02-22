package sk.kasv.degro.Hibernate.Repository.CategoryData;

import java.util.List;

import sk.kasv.degro.Hibernate.Database.Entity.Category;


public interface ICategoryRepository {
    List<Category> getAllCategories();
}
