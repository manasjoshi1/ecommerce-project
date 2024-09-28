CREATE TABLE `inventory`
(
    id bigint(20) not null auto_increment primary key,
    sku_code VARCHAR(50) NOT NULL,
    qty INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

)