package de.thaum.lifedatabase.groceries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroceriesController {

    private final CategoryRepository categoryRepository;
    private final GroceryRepository groceryRepository;
    private final GroceryCategoryRepository groceryCategoryRepository;
    private final GroceryPurchaseRepository groceryPurchaseRepository;

    public GroceriesController(CategoryRepository categoryRepository, GroceryRepository groceryRepository, GroceryCategoryRepository groceryCategoryRepository, GroceryPurchaseRepository groceryPurchaseRepository) {
        this.categoryRepository = categoryRepository;
        this.groceryRepository = groceryRepository;
        this.groceryCategoryRepository = groceryCategoryRepository;
        this.groceryPurchaseRepository = groceryPurchaseRepository;
    }

    @GetMapping("/categories/all")
    public Page<Category> getCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.categoryRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/groceries/all")
    public Page<Grocery> getGroceries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.groceryRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/groceries")
    public Page<Grocery> getGroceriesFiltered(
            @RequestParam() String name,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size
    ) {
        Specification<Grocery> spec = Specification
                .where(GroceriesSpecifications.hasName(name));

        return this.groceryRepository.findAll(spec, PageRequest.of(page, size));
    }

    @GetMapping("/groceryCategories/all")
    public Page<GroceryCategory> getGroceryCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.groceryCategoryRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/groceryPurchases/all")
    public Page<GroceryPurchase> getGroceryPurchases(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.groceryPurchaseRepository.findAll(PageRequest.of(page, size));
    }
}
