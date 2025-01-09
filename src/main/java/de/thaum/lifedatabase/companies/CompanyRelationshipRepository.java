package de.thaum.lifedatabase.companies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRelationshipRepository extends JpaRepository<CompanyRelationship, CompanyRelationshipId> {
}