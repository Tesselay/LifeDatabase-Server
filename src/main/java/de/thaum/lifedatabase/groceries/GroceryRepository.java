package de.thaum.lifedatabase.groceries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroceryRepository extends JpaRepository<Grocery, Long>, JpaSpecificationExecutor<Grocery> {
}