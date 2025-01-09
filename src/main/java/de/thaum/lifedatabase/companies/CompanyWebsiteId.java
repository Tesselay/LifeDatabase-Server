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
public class CompanyWebsiteId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4162714756637372191L;
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "website_id", nullable = false)
    private Long websiteId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyWebsiteId entity = (CompanyWebsiteId) o;
        return Objects.equals(this.companyId, entity.companyId) &&
                Objects.equals(this.websiteId, entity.websiteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, websiteId);
    }

}