package pl.dgadecki.springworkshoprestapi.business.customer.dto.api;

import pl.dgadecki.springworkshoprestapi.business.customer.dto.Customer;

import java.util.List;

public record GetAllCustomersResponse(
        List<CustomerResponse> customers
) {
    public static GetAllCustomersResponse from(List<Customer> customers) {
        List<CustomerResponse> customerResponses = customers.stream()
                .map(CustomerResponse::fromCustomer)
                .toList();
        return new GetAllCustomersResponse(customerResponses);
    }
}
