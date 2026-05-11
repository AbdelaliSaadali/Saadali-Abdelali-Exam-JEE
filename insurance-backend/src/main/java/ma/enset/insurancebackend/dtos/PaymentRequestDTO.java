package ma.enset.insurancebackend.dtos;

import lombok.Data;
import ma.enset.insurancebackend.enums.PaymentType;

@Data
public class PaymentRequestDTO {
    private String contractId;
    private double amount;
    private PaymentType type;
    private String description;
}
