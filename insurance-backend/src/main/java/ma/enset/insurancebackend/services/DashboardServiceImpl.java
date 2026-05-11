package ma.enset.insurancebackend.services;

import lombok.AllArgsConstructor;
import ma.enset.insurancebackend.dtos.DashboardDTO;
import ma.enset.insurancebackend.entities.CarInsuranceContract;
import ma.enset.insurancebackend.entities.HealthInsuranceContract;
import ma.enset.insurancebackend.entities.HomeInsuranceContract;
import ma.enset.insurancebackend.mappers.InsuranceMapperImpl;
import ma.enset.insurancebackend.repositories.CustomerRepository;
import ma.enset.insurancebackend.repositories.InsuranceContractRepository;
import ma.enset.insurancebackend.repositories.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private CustomerRepository customerRepository;
    private InsuranceContractRepository contractRepository;
    private PaymentRepository paymentRepository;
    private InsuranceMapperImpl dtoMapper;

    @Override
    public DashboardDTO getDashboard() {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setTotalCustomers(customerRepository.count());
        dashboardDTO.setTotalContracts(contractRepository.count());
        dashboardDTO.setTotalPayments(paymentRepository.count());
        dashboardDTO.setTotalCarContracts(contractRepository.findAll().stream().filter(contract -> contract instanceof CarInsuranceContract).count());
        dashboardDTO.setTotalHomeContracts(contractRepository.findAll().stream().filter(contract -> contract instanceof HomeInsuranceContract).count());
        dashboardDTO.setTotalHealthContracts(contractRepository.findAll().stream().filter(contract -> contract instanceof HealthInsuranceContract).count());
        dashboardDTO.setTotalPaymentAmount(paymentRepository.findAll().stream().mapToDouble(payment -> payment.getAmount()).sum());
        dashboardDTO.setRecentCustomers(customerRepository.findAll().stream().limit(5).map(customer -> dtoMapper.fromCustomer(customer)).collect(Collectors.toList()));
        dashboardDTO.setRecentContracts(contractRepository.findAll().stream().limit(5).map(contract -> dtoMapper.fromContract(contract)).collect(Collectors.toList()));
        dashboardDTO.setRecentPayments(paymentRepository.findAll().stream().limit(5).map(payment -> dtoMapper.fromPayment(payment)).collect(Collectors.toList()));
        return dashboardDTO;
    }
}
