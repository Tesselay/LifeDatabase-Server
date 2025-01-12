package de.thaum.lifedatabase.groceries;

import org.springframework.data.jpa.domain.Specification;

public class GrocerySpecifications {
    public static Specification<Grocery> hasName(String name) {
        return (root, query, criteriaBuilder) -> name == null || name.isEmpty()
                ? null
                : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Grocery> hasContent(Integer content) {
        return (root, query, criteriaBuilder) -> content == null
                ? null
                : criteriaBuilder.equal(root.get("content"), content);
    }
}