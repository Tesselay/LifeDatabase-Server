package de.thaum.lifedatabase.groceries;

import de.thaum.lifedatabase.common.Address;
import de.thaum.lifedatabase.common.Unit;
import de.thaum.lifedatabase.common.Website;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "grocery_purchases", schema = "groceries")
public class GroceryPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "article_id", nullable = false)
    private Grocery article;

    @Column(name = "price", precision = 1000, scale = 2)
    private BigDecimal price;

    @Column(name = "price_per_unit", precision = 1000, scale = 2)
    private BigDecimal pricePerUnit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(name = "offer")
    private Boolean offer;

    @Column(name = "purchase_date")
    private OffsetDateTime purchaseDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_place_physical")
    private Address purchasePlacePhysical;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_place_online")
    private Website purchasePlaceOnline;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}