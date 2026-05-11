package ma.enset.insurancebackend.dtos;

import lombok.Data;
import ma.enset.insurancebackend.enums.ContractStatus;

import java.util.List;

@Data
public class ContractHistoryDTO {
    private String contractId;
    private ContractStatus status;
    private double contributionAmount;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<PaymentDTO> paymentDTOS;
}
