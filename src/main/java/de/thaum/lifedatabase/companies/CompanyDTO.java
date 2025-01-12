package de.thaum.lifedatabase.companies;

import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link Company}
 */
@Value
public class CompanyDTO {
    Long id;
    String name;
}