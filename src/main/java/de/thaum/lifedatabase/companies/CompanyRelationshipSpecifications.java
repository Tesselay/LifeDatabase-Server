package de.thaum.lifedatabase.companies;

import org.springframework.data.jpa.domain.Specification;

public class CompanyRelationshipSpecifications {

    public static Specification<CompanyRelationship> hasParentCompanyId(Long parentCompanyId) {
        return (root, query, criteriaBuilder) -> parentCompanyId == null
                ? null
                : criteriaBuilder.equal(root.get("parentCompany").get("id"), parentCompanyId);
    }

    public static Specification<CompanyRelationship> hasChildCompanyId(Long childCompanyId) {
        return (root, query, criteriaBuilder) -> childCompanyId == null
                ? null
                : criteriaBuilder.equal(root.get("childCompany").get("id"), childCompanyId);
    }
}