package de.thaum.lifedatabase.groceries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryCategoryRepository extends JpaRepository<GroceryCategory, GroceryCategoryId> {
}