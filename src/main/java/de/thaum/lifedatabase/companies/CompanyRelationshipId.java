package de.thaum.lifedatabase.companies;

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
public class CompanyRelationshipId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4309096047317036428L;
    @Column(name = "parent_company_id", nullable = false)
    private Long parentCompanyId;

    @Column(name = "child_company_id", nullable = false)
    private Long childCompanyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyRelationshipId entity = (CompanyRelationshipId) o;
        return Objects.equals(this.parentCompanyId, entity.parentCompanyId) &&
                Objects.equals(this.childCompanyId, entity.childCompanyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCompanyId, childCompanyId);
    }

}