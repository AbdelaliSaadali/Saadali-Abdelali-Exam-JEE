package ma.enset.insurancebackend.dtos;

import lombok.Data;
import ma.enset.insurancebackend.enums.PaymentType;

import java.util.Date;

@Data
public class PaymentDTO {
    private Long id;
    private Date paymentDate;
    private double amount;
    private PaymentType type;
    private String description;
}
