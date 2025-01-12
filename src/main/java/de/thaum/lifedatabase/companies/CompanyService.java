package de.thaum.lifedatabase.companies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyRelationshipRepository companyRelationshipRepository;

    public CompanyService(CompanyRepository companyRepository, CompanyRelationshipRepository companyRelationshipRepository) {
        this.companyRepository = companyRepository;
        this.companyRelationshipRepository = companyRelationshipRepository;
    }

    public Page<CompanyWithRelationshipsDTO> getCompaniesWithRelationships(String name, Pageable pageable) {
        Specification<Company> companySpec = CompanySpecifications.hasNameLike(name);

        // Fetch paginated companies
        Page<Company> companiesPage = companyRepository.findAll(companySpec, pageable);

        // Map each company entity to a CompanyWithRelationshipsDTO
        List<CompanyWithRelationshipsDTO> content = new ArrayList<>();
        for (Company company : companiesPage.getContent()) {
            CompanyWithRelationshipsDTO dto = new CompanyWithRelationshipsDTO();
            dto.setId(company.getId());
            dto.setName(company.getName());

            List<CompanyDTO> parentCompanies = new ArrayList<>();
            List<CompanyDTO> childCompanies = new ArrayList<>();

            // Fetch relationships dynamically using Specification
            Specification<CompanyRelationship> relationshipSpec = Specification
                    .where(CompanyRelationshipSpecifications.hasParentCompanyId(company.getId()))
                    .or(CompanyRelationshipSpecifications.hasChildCompanyId(company.getId()));

            List<CompanyRelationship> relationships = companyRelationshipRepository.findAll(relationshipSpec);

            // Populate parent and child companies
            for (CompanyRelationship relationship : relationships) {
                if (relationship.getParentCompany().getId().equals(company.getId())) {
                    childCompanies.add(
                            new CompanyDTO(
                                    relationship.getChildCompany().getId(),
                                    relationship.getChildCompany().getName()
                            )
                    );
                } else {
                    parentCompanies.add(
                            new CompanyDTO(
                                    relationship.getParentCompany().getId(),
                                    relationship.getParentCompany().getName()
                            )
                    );
                }
            }

            dto.setParentCompanies(parentCompanies);
            dto.setChildCompanies(childCompanies);

            content.add(dto);
        }

        // Wrap the DTOs into a Page object
        return companiesPage.map(company -> content.get(companiesPage.getContent().indexOf(company)));
    }
}