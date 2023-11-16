package pl.dgadecki.springworkshoprestapi.business.customer.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.dgadecki.springworkshoprestapi.business.customer.domain.service.CustomerService;
import pl.dgadecki.springworkshoprestapi.business.customer.dto.Customer;
import pl.dgadecki.springworkshoprestapi.business.customer.dto.api.*;

@Slf4j
@RequestMapping("/api/v1/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getCustomerById(@PathVariable("id") Long id) {
        return CustomerResponse.fromCustomer(customerService.fetchCustomerById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllCustomersResponse getAllCustomersResponse() {
        return GetAllCustomersResponse.from(customerService.findAllCustomers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostCustomerResponse createCustomer(@RequestBody PostCustomerRequest postCustomerRequest) {
        Customer createdCustomer = customerService.saveCustomer(postCustomerRequest.toCustomer());
        return PostCustomerResponse.from(createdCustomer);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateCustomerResponse updateCustomer(@PathVariable("id") Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        Customer updatedCustomer = customerService.updateCustomer(id, updateCustomerRequest.toCustomer());
        return UpdateCustomerResponse.from(updatedCustomer);
    }

}
