package ma.enset.insurancebackend.repositories;

import ma.enset.insurancebackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContainsIgnoreCase(String keyword);
}
