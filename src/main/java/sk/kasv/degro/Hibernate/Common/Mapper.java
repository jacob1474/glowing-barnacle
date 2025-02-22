package sk.kasv.degro.Hibernate.Common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import sk.kasv.degro.Hibernate.Contracts.CategoryData.CategoryDataDtoOut;
import sk.kasv.degro.Hibernate.Contracts.UserData.UserDataDtoOut;
import sk.kasv.degro.Hibernate.Database.Entity.User;
import sk.kasv.degro.Hibernate.Database.Entity.Category;

@Component
public class Mapper {
    public UserDataDtoOut ToUserDataDtoOut(User user){
        UserDataDtoOut userDataDtoOut = new UserDataDtoOut();
        userDataDtoOut.name = user.getName();
        userDataDtoOut.email = user.getEmail();
        userDataDtoOut.age = user.getAge();
        userDataDtoOut.weight = user.getWeight();

        return userDataDtoOut;
    }

    public List<UserDataDtoOut> ToUserDataDtoOut(List<User> users){
        List<UserDataDtoOut> userDataDtoOutList = new ArrayList<UserDataDtoOut>();

        for(User user : users){
            userDataDtoOutList.add(ToUserDataDtoOut(user));
        }

        return userDataDtoOutList;
    }

    public CategoryDataDtoOut ToCategoryDataDtoOut(Category category){
        CategoryDataDtoOut categoryDataDtoOut = new CategoryDataDtoOut();
        categoryDataDtoOut.name = category.getName();
        categoryDataDtoOut.id = category.getId();

        return categoryDataDtoOut;
    }

    public List<CategoryDataDtoOut> ToCategoryDataDtoOut(List<Category> categories){
        List<CategoryDataDtoOut> categoryDataDtoOutList = new ArrayList<CategoryDataDtoOut>();

        for(Category category : categories){
            categoryDataDtoOutList.add(ToCategoryDataDtoOut(category));
        }

        return categoryDataDtoOutList;
    }
}
