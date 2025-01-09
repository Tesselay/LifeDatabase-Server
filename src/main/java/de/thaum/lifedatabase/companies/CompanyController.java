package de.thaum.lifedatabase.companies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    private final BrandRepository brandRepository;
    private final CompanyRepository companyRepository;
    private final CompanyAddressRepository companyAddressRepository;
    private final CompanyRelationshipRepository companyRelationshipRepository;
    private final CompanyWebsiteRepository companyWebsiteRepository;

    public CompanyController(BrandRepository brandRepository, CompanyRepository companyRepository, CompanyAddressRepository companyAddressRepository, CompanyRelationshipRepository companyRelationshipRepository, CompanyWebsiteRepository companyWebsiteRepository) {
        this.brandRepository = brandRepository;
        this.companyRepository = companyRepository;
        this.companyAddressRepository = companyAddressRepository;
        this.companyRelationshipRepository = companyRelationshipRepository;
        this.companyWebsiteRepository = companyWebsiteRepository;
    }

    @GetMapping("/brands")
    public Page<Brand> getBrands(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.brandRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companies")
    public Page<Company> getCompanies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companyAdresses")
    public Page<CompanyAddress> getCompanyAdresses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyAddressRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companyRelationships")
    public Page<CompanyRelationship> getCompanyRelationships(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyRelationshipRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/companyWebsites")
    public Page<CompanyWebsite> getCompanyWebsites(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.companyWebsiteRepository.findAll(PageRequest.of(page, size));
    }

}
