package de.thaum.lifedatabase.companies;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CompanyAddressId implements Serializable {
    private static final long serialVersionUID = 2510970893132996426L;
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyAddressId entity = (CompanyAddressId) o;
        return Objects.equals(this.companyId, entity.companyId) &&
                Objects.equals(this.addressId, entity.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, addressId);
    }

}