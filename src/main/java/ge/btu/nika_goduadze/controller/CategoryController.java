package ge.btu.nika_goduadze.controller;

import ge.btu.nika_goduadze.dto.category.AddCategoryInput;
import ge.btu.nika_goduadze.dto.category.AddCategoryOutput;
import ge.btu.nika_goduadze.dto.category.GetCategoriesInput;
import ge.btu.nika_goduadze.dto.category.GetCategoriesOutput;
import ge.btu.nika_goduadze.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("getCategories")
    public GetCategoriesOutput getCategories(@RequestBody(required = false) GetCategoriesInput getCategoriesInput) {
        return categoryService.getCategories(getCategoriesInput);
    }

    @PostMapping("addCategory")
    public AddCategoryOutput addCategory(@RequestBody AddCategoryInput addCategoryInput) {
        return categoryService.addCategory(addCategoryInput);
    }
}