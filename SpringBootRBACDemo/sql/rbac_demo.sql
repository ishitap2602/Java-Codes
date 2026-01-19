
-- Create database
CREATE DATABASE rbac_demo;

-- Create app user (change password as needed)
CREATE USER 'rbac_user'@'localhost' IDENTIFIED BY 'rbac_password';

-- Grant privileges
GRANT ALL PRIVILEGES ON rbac_demo.* TO 'rbac_user'@'localhost';
FLUSH PRIVILEGES;

use rbac_demo;

CREATE TABLE users (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(200) NOT NULL,
  role VARCHAR(20) NOT NULL,  -- 'ADMIN','MANAGER','USER'
  enabled BIT NOT NULL DEFAULT b'1'
);

CREATE TABLE products (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  description VARCHAR(1000),
  price DECIMAL(12,2) NOT NULL DEFAULT 0.00
);

