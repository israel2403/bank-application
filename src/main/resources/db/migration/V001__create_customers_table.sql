-- Create customers table
CREATE TABLE customers (
    id BINARY(16) NOT NULL COMMENT 'Unique identifier for the customer',
    email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Customer email address',
    pwd VARCHAR(255) NOT NULL COMMENT 'Hashed password for the customer',
    role VARCHAR(50) NOT NULL COMMENT 'Role of the customer (e.g., ADMIN, USER)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Record creation timestamp',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Record last update timestamp',
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Table to store customer information';