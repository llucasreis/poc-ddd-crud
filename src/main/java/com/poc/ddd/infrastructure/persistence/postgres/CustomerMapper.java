package com.poc.ddd.infrastructure.persistence.postgres;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.vos.Document;
import org.springframework.stereotype.Component;

public class CustomerMapper {

    public static CustomerModel toPersistence(Customer domainCustomer) {
        CustomerModel model = new CustomerModel();
        model.setId(domainCustomer.getId());
        model.setName(domainCustomer.getName());
        model.setDocumentType(domainCustomer.getDocument().getType());
        model.setDocumentNumber(domainCustomer.getDocument().getNumber());
        return model;
    }

    public static Customer toDomain(CustomerModel model) {
        return new Customer(
                model.getId(),
                model.getName(),
                new Document(model.getDocumentType(), model.getDocumentNumber())
        );
    }
}
