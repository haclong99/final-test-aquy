package vn.fis.finaltestaquy.service;

import org.springframework.data.domain.Pageable;
import vn.fis.finaltestaquy.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    Customer findById(Long id);
    List<Customer> findAllCustomer(Pageable pageable);
}
