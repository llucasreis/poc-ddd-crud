CREATE TABLE customers (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    document_type VARCHAR(255) NOT NULL,
    document_number VARCHAR(255) NOT NULL
);
