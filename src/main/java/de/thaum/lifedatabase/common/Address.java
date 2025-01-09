package de.thaum.lifedatabase.common;

import de.thaum.lifedatabase.companies.CompanyAddress;
import de.thaum.lifedatabase.groceries.GroceryPurchase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "addresses", schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street_name", length = Integer.MAX_VALUE)
    private String streetName;

    @Column(name = "street_number", length = Integer.MAX_VALUE)
    private String streetNumber;

    @Column(name = "postal", length = Integer.MAX_VALUE)
    private String postal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "address")
    private Set<CompanyAddress> companyAddresses = new LinkedHashSet<>();

    @OneToOne(mappedBy = "purchasePlacePhysical")
    private GroceryPurchase groceryPurchase;

}