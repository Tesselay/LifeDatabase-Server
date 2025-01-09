package de.thaum.lifedatabase.groceries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryPurchaseRepository extends JpaRepository<GroceryPurchase, Long> {
}