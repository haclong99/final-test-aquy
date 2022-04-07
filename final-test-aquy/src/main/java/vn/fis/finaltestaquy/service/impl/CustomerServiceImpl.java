package vn.fis.finaltestaquy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaquy.entity.Customer;
import vn.fis.finaltestaquy.exception.CustomerNotFoundException;
import vn.fis.finaltestaquy.repository.CustomerRepository;
import vn.fis.finaltestaquy.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerRequest) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer", "id", id));

        customer.setName(customerRequest.getName());
        customer.setBirthday(customerRequest.getBirthday());
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> result = customerRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new CustomerNotFoundException("Customer", "id", id);
        }
    }

    @Override
    public List<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

}
