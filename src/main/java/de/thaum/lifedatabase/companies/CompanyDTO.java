package de.thaum.lifedatabase.companies;

import lombok.Value;

/**
 * DTO for {@link Company}
 */
@Value
public class CompanyDTO {
    Long id;
    String name;
}