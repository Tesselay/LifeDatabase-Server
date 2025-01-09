package de.thaum.lifedatabase.companies;

import de.thaum.lifedatabase.groceries.Grocery;
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
@Table(name = "companies", schema = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "company")
    private Set<Brand> brands = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<CompanyAddress> companyAddresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<CompanyWebsite> companyWebsites = new LinkedHashSet<>();

    @OneToMany(mappedBy = "manufacturer")
    private Set<Grocery> groceries = new LinkedHashSet<>();

}