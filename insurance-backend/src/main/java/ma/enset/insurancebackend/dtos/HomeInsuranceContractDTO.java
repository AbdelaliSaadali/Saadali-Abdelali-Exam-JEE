package ma.enset.insurancebackend.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.enset.insurancebackend.enums.HousingType;

@Data @EqualsAndHashCode(callSuper = true)
public class HomeInsuranceContractDTO extends InsuranceContractDTO {
    private HousingType housingType;
    private String housingAddress;
    private double surface;
}
