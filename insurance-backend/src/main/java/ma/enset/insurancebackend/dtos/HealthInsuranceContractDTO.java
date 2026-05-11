package ma.enset.insurancebackend.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.enset.insurancebackend.enums.CoverageLevel;

@Data @EqualsAndHashCode(callSuper = true)
public class HealthInsuranceContractDTO extends InsuranceContractDTO {
    private CoverageLevel coverageLevel;
    private int coveredPersons;
}
