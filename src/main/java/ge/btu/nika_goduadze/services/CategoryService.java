package ge.btu.nika_goduadze.services;

import ge.btu.nika_goduadze.dto.category.AddCategoryInput;
import ge.btu.nika_goduadze.dto.category.AddCategoryOutput;
import ge.btu.nika_goduadze.dto.category.GetCategoriesInput;
import ge.btu.nika_goduadze.dto.category.GetCategoriesOutput;

public interface CategoryService {
    // კატეგორიების წამოღება
    GetCategoriesOutput getCategories(GetCategoriesInput getCategoriesInput);

    // კატეგორიების დამატება
    AddCategoryOutput addCategory(AddCategoryInput addCategoryInput);
}