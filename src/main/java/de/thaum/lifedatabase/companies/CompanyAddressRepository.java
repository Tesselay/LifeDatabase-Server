package de.thaum.lifedatabase.companies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, CompanyAddressId> {
}