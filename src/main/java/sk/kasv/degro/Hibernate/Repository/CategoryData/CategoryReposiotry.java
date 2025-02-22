package sk.kasv.degro.Hibernate.Repository.CategoryData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import sk.kasv.degro.Hibernate.Database.Entity.Category;

@Repository
public class CategoryReposiotry implements ICategoryRepository {
    private EntityManager entityManager;

    @Autowired
    public CategoryReposiotry(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }
}
