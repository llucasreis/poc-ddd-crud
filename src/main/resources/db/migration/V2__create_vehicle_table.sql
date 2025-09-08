CREATE TABLE vehicles (
      id UUID PRIMARY KEY,
      license_plate VARCHAR(255) NOT NULL,
      customer_id UUID NOT NULL,
      CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES customers(id)
);