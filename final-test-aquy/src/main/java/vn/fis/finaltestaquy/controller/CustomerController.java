package vn.fis.finaltestaquy.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.finaltestaquy.dto.CustomerDto;
import vn.fis.finaltestaquy.entity.Customer;
import vn.fis.finaltestaquy.service.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable(name = "id") Long id) {
        Customer customer = customerService.findById(id);

        CustomerDto customerResponse = modelMapper.map(customer, CustomerDto.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto) {

        Customer customerRequest = modelMapper.map(customerDto, Customer.class);
        Customer customer = customerService.createCustomer(customerRequest);

        CustomerDto customerResponse = modelMapper.map(customer, CustomerDto.class);

        return new ResponseEntity<CustomerDto>(customerResponse, HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable long id, @RequestBody CustomerDto customerDto) {

        Customer customerRequest = modelMapper.map(customerDto, Customer.class);
        Customer customer = customerService.updateCustomer(id, customerRequest);

        CustomerDto customerResponse = modelMapper.map(customer, CustomerDto.class);

        return ResponseEntity.ok().body(customerResponse);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> findCustomers(@RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size){
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page.orElse(1) - 1, size.orElse(6), sort);
        return ResponseEntity.ok(customerService.findAllCustomer(pageable));
    }
}
