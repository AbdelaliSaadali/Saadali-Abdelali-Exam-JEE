package ma.enset.insurancebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.insurancebackend.dtos.CarInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.ContractHistoryDTO;
import ma.enset.insurancebackend.dtos.CreateCarContractDTO;
import ma.enset.insurancebackend.dtos.CreateHealthContractDTO;
import ma.enset.insurancebackend.dtos.CreateHomeContractDTO;
import ma.enset.insurancebackend.dtos.HealthInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.HomeInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.InsuranceContractDTO;
import ma.enset.insurancebackend.dtos.PaymentDTO;
import ma.enset.insurancebackend.dtos.PaymentRequestDTO;
import ma.enset.insurancebackend.exceptions.ContractNotFoundException;
import ma.enset.insurancebackend.exceptions.CustomerNotFoundException;
import ma.enset.insurancebackend.services.InsuranceService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InsuranceContractRestAPI {
    private InsuranceService insuranceService;

    @GetMapping("/contracts")
    public List<InsuranceContractDTO> contracts() {
        return insuranceService.contractList();
    }

    @GetMapping("/contracts/{contractId}")
    public InsuranceContractDTO getContract(@PathVariable String contractId) throws ContractNotFoundException {
        return insuranceService.getContract(contractId);
    }

    @GetMapping("/contracts/customer/{customerId}")
    public List<InsuranceContractDTO> getContractsByCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        return insuranceService.getContractsByCustomer(customerId);
    }

    @PostMapping("/contracts/car")
    public CarInsuranceContractDTO saveCarContract(@RequestBody CreateCarContractDTO dto) throws CustomerNotFoundException {
        return insuranceService.saveCarContract(dto);
    }

    @PostMapping("/contracts/home")
    public HomeInsuranceContractDTO saveHomeContract(@RequestBody CreateHomeContractDTO dto) throws CustomerNotFoundException {
        return insuranceService.saveHomeContract(dto);
    }

    @PostMapping("/contracts/health")
    public HealthInsuranceContractDTO saveHealthContract(@RequestBody CreateHealthContractDTO dto) throws CustomerNotFoundException {
        return insuranceService.saveHealthContract(dto);
    }

    @PutMapping("/contracts/{contractId}/validate")
    public InsuranceContractDTO validateContract(@PathVariable String contractId) throws ContractNotFoundException {
        return insuranceService.validateContract(contractId);
    }

    @PutMapping("/contracts/{contractId}/cancel")
    public InsuranceContractDTO cancelContract(@PathVariable String contractId) throws ContractNotFoundException {
        return insuranceService.cancelContract(contractId);
    }

    @DeleteMapping("/contracts/{contractId}")
    public void deleteContract(@PathVariable String contractId) {
        insuranceService.deleteContract(contractId);
    }

    @PostMapping("/contracts/payments")
    public PaymentDTO addPayment(@RequestBody PaymentRequestDTO dto) throws ContractNotFoundException {
        return insuranceService.addPayment(dto);
    }

    @GetMapping("/contracts/{contractId}/payments")
    public List<PaymentDTO> getPayments(@PathVariable String contractId) {
        return insuranceService.paymentHistory(contractId);
    }

    @GetMapping("/contracts/{contractId}/pagePayments")
    public ContractHistoryDTO getContractHistory(@PathVariable String contractId, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) throws ContractNotFoundException {
        return insuranceService.getContractHistory(contractId, page, size);
    }
}
