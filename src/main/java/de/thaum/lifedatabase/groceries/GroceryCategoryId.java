package de.thaum.lifedatabase.groceries;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GroceryCategoryId implements Serializable {
    @Serial
    private static final long serialVersionUID = 3182085892918844259L;
    @Column(name = "grocery_id", nullable = false)
    private Long groceryId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GroceryCategoryId entity = (GroceryCategoryId) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.groceryId, entity.groceryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, groceryId);
    }

}