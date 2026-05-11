package ma.enset.insurancebackend.services;

import ma.enset.insurancebackend.dtos.CarInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.ContractHistoryDTO;
import ma.enset.insurancebackend.dtos.CreateCarContractDTO;
import ma.enset.insurancebackend.dtos.CreateHealthContractDTO;
import ma.enset.insurancebackend.dtos.CreateHomeContractDTO;
import ma.enset.insurancebackend.dtos.CustomerDTO;
import ma.enset.insurancebackend.dtos.HealthInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.HomeInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.InsuranceContractDTO;
import ma.enset.insurancebackend.dtos.PaymentDTO;
import ma.enset.insurancebackend.dtos.PaymentRequestDTO;
import ma.enset.insurancebackend.exceptions.ContractNotFoundException;
import ma.enset.insurancebackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface InsuranceService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> listCustomers();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<CustomerDTO> searchCustomers(String keyword);
    CarInsuranceContractDTO saveCarContract(CreateCarContractDTO dto) throws CustomerNotFoundException;
    HomeInsuranceContractDTO saveHomeContract(CreateHomeContractDTO dto) throws CustomerNotFoundException;
    HealthInsuranceContractDTO saveHealthContract(CreateHealthContractDTO dto) throws CustomerNotFoundException;
    List<InsuranceContractDTO> contractList();
    InsuranceContractDTO getContract(String contractId) throws ContractNotFoundException;
    List<InsuranceContractDTO> getContractsByCustomer(Long customerId) throws CustomerNotFoundException;
    InsuranceContractDTO validateContract(String contractId) throws ContractNotFoundException;
    InsuranceContractDTO cancelContract(String contractId) throws ContractNotFoundException;
    void deleteContract(String contractId);
    PaymentDTO addPayment(PaymentRequestDTO dto) throws ContractNotFoundException;
    List<PaymentDTO> paymentHistory(String contractId);
    ContractHistoryDTO getContractHistory(String contractId, int page, int size) throws ContractNotFoundException;
}
