package de.thaum.lifedatabase.companies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyRelationshipRepository extends JpaRepository<CompanyRelationship, CompanyRelationshipId>, JpaSpecificationExecutor<CompanyRelationship> {
}