package pl.dgadecki.springworkshoprestapi.business.customer.dto.api;

import pl.dgadecki.springworkshoprestapi.business.customer.dto.Customer;

public record PostCustomerResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
    public static PostCustomerResponse from(Customer customer) {
        return new PostCustomerResponse(
                customer.id(),
                customer.firstName(),
                customer.lastName(),
                customer.email(),
                customer.phoneNumber()
        );
    }
}
