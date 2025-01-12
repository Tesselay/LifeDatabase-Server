package de.thaum.lifedatabase.companies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompaniesController {

    private final BrandRepository brandRepository;
    private final CompanyRepository companyRepository;
    private final CompanyAddressRepository companyAddressRepository;
    private final CompanyRelationshipRepository companyRelationshipRepository;
    private final CompanyWebsiteRepository companyWebsiteRepository;
    private final CompanyService companyService;

    public CompaniesController(BrandRepository brandRepository, CompanyRepository companyRepository, CompanyAddressRepository companyAddressRepository, CompanyRelationshipRepository companyRelationshipRepository, CompanyWebsiteRepository companyWebsiteRepository, CompanyService companyService) {
        this.brandRepository = brandRepository;
        this.companyRepository = companyRepository;
        this.companyAddressRepository = companyAddressRepository;
        this.companyRelationshipRepository = companyRelationshipRepository;
        this.companyWebsiteRepository = companyWebsiteRepository;
        this.companyService = companyService;
    }

    @GetMapping("/brands/all")
    public Page<Brand> getBrands(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.brandRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companies")
    public Page<CompanyWithRelationshipsDTO> getCompanies(
            @RequestParam() String name,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size
    ) {
        return this.companyService.getCompaniesWithRelationships(name, PageRequest.of(page, size));
    }

    @GetMapping("/companyAdresses/all")
    public Page<CompanyAddress> getCompanyAdresses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyAddressRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companyRelationships/all")
    public Page<CompanyRelationship> getCompanyRelationships(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyRelationshipRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companyWebsites/all")
    public Page<CompanyWebsite> getCompanyWebsites(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyWebsiteRepository.findAll(PageRequest.of(page, size));
    }

}
