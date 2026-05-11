package ma.enset.insurancebackend.dtos;

import lombok.Data;
import ma.enset.insurancebackend.enums.HousingType;

@Data
public class CreateHomeContractDTO {
    private double contributionAmount;
    private int duration;
    private double coverageRate;
    private Long customerId;
    private HousingType housingType;
    private String housingAddress;
    private double surface;
}
