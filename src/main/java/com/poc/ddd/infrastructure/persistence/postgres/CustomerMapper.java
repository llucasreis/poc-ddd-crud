package com.poc.ddd.infrastructure.persistence.postgres;

import com.poc.ddd.domain.entities.Customer;
import com.poc.ddd.domain.vos.CustomerId;
import com.poc.ddd.domain.vos.Document;

public class CustomerMapper {

    public static CustomerModel toPersistence(Customer domainCustomer) {
        CustomerModel model = new CustomerModel();
        model.setId(domainCustomer.getId().value());
        model.setName(domainCustomer.getName());
        model.setDocumentType(domainCustomer.getDocument().getType());
        model.setDocumentNumber(domainCustomer.getDocument().getNumber());
        return model;
    }

    public static Customer toDomain(CustomerModel model) {
        CustomerId customerId = new CustomerId(model.getId());
        Document document = new Document(model.getDocumentType(), model.getDocumentNumber());
        return Customer.restore(customerId, model.getName(),
                document);
    }
}
