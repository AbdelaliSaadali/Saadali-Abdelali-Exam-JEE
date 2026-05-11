package ma.enset.insurancebackend.mappers;

import ma.enset.insurancebackend.dtos.CarInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.CustomerDTO;
import ma.enset.insurancebackend.dtos.HealthInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.HomeInsuranceContractDTO;
import ma.enset.insurancebackend.dtos.InsuranceContractDTO;
import ma.enset.insurancebackend.dtos.PaymentDTO;
import ma.enset.insurancebackend.entities.CarInsuranceContract;
import ma.enset.insurancebackend.entities.Customer;
import ma.enset.insurancebackend.entities.HealthInsuranceContract;
import ma.enset.insurancebackend.entities.HomeInsuranceContract;
import ma.enset.insurancebackend.entities.InsuranceContract;
import ma.enset.insurancebackend.entities.Payment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InsuranceMapperImpl {
    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    public CarInsuranceContractDTO fromCarContract(CarInsuranceContract contract) {
        CarInsuranceContractDTO dto = new CarInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setCustomerDTO(fromCustomer(contract.getCustomer()));
        dto.setType(contract.getClass().getSimpleName());
        return dto;
    }

    public HomeInsuranceContractDTO fromHomeContract(HomeInsuranceContract contract) {
        HomeInsuranceContractDTO dto = new HomeInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setCustomerDTO(fromCustomer(contract.getCustomer()));
        dto.setType(contract.getClass().getSimpleName());
        return dto;
    }

    public HealthInsuranceContractDTO fromHealthContract(HealthInsuranceContract contract) {
        HealthInsuranceContractDTO dto = new HealthInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setCustomerDTO(fromCustomer(contract.getCustomer()));
        dto.setType(contract.getClass().getSimpleName());
        return dto;
    }

    public InsuranceContractDTO fromContract(InsuranceContract contract) {
        if (contract instanceof CarInsuranceContract) {
            return fromCarContract((CarInsuranceContract) contract);
        }
        if (contract instanceof HomeInsuranceContract) {
            return fromHomeContract((HomeInsuranceContract) contract);
        }
        return fromHealthContract((HealthInsuranceContract) contract);
    }

    public PaymentDTO fromPayment(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        BeanUtils.copyProperties(payment, paymentDTO);
        return paymentDTO;
    }
}
