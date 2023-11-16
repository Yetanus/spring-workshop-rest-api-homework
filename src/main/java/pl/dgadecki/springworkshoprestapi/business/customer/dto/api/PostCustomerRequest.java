package pl.dgadecki.springworkshoprestapi.business.customer.dto.api;

import pl.dgadecki.springworkshoprestapi.business.customer.dto.Customer;

public record PostCustomerRequest(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
    public Customer toCustomer() {
        return new Customer(null, firstName, lastName, email, phoneNumber);
    }
}
