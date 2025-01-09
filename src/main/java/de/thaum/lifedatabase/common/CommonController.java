package de.thaum.lifedatabase.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommonController {

    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final UnitRepository unitRepository;
    private final WebsiteRepository websiteRepository;

    public CommonController(AddressRepository addressRepository, CountryRepository countryRepository, CityRepository cityRepository, UnitRepository unitRepository, WebsiteRepository websiteRepository) {
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.unitRepository = unitRepository;
        this.websiteRepository = websiteRepository;
    }

    @GetMapping("/addresses")
    public Page<Address> getAddresses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.addressRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/countries")
    public Page<Country> getCountries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.countryRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/cities")
    public Page<City> getCities(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.cityRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/units")
    public Page<Unit> getUnits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.unitRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/websites")
    public Page<Website> getWebsites(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return this.websiteRepository.findAll(PageRequest.of(page, size));
    }
}
