package de.thaum.lifedatabase.common;

import de.thaum.lifedatabase.companies.CompanyWebsite;
import de.thaum.lifedatabase.groceries.GroceryPurchase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "websites", schema = "public")
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "url", length = Integer.MAX_VALUE)
    private String url;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "website")
    private Set<CompanyWebsite> companyWebsites = new LinkedHashSet<>();

    @OneToOne(mappedBy = "purchasePlaceOnline")
    private GroceryPurchase groceryPurchase;

}