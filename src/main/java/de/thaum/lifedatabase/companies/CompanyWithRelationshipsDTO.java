package de.thaum.lifedatabase.companies;

import lombok.Data;

import java.util.List;

@Data
public class CompanyWithRelationshipsDTO {
    private Long id;
    private String name;
    private List<CompanyDTO> parentCompanies;
    private List<CompanyDTO> childCompanies;
}