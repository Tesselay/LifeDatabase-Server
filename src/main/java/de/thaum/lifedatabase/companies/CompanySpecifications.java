package de.thaum.lifedatabase.companies;

import org.springframework.data.jpa.domain.Specification;

public class CompanySpecifications {

    public static Specification<Company> hasNameLike(String name) {
        return (root, query, criteriaBuilder) -> name == null || name.isBlank()
                ? null // No filtering if name is null or blank
                : criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")), // Case-insensitive
                "%" + name.toLowerCase() + "%"
        );
    }
}