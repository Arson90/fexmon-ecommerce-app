# CREATE TABLE user (
#     id BIGINT NOT NULL AUTO_INCREMENT,
#     first_name VARCHAR(255) NOT NULL,
#     last_name VARCHAR(255) NOT NULL,
#     email VARCHAR(255) NOT NULL,
#     country VARCHAR(255) NOT NULL,
#     PRIMARY KEY (id)
# );
#
# CREATE TABLE 'order' (
#     id BIGINT NOT NULL AUTO_INCREMENT,
#     customer_name VARCHAR(255) NOT NULL,
#     phone_number VARCHAR(255) NOT NULL,
#     address_id INTEGER,
#     country VARCHAR(255) NOT NULL,
#     payment_type VARCHAR(255),
#     PRIMARY KEY (id)
# );
#
CREATE TABLE product (
    product_id BIGINT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE cart (
    id          BIGINT NOT NULL AUTO_INCREMENT,
    product_id  INTEGER,
    total_price DOUBLE,
    quantity    INTEGER,
    PRIMARY KEY (id)
);
#
# CREATE TABLE category (
#     id BIGINT NOT NULL AUTO_INCREMENT,
#     category_name VARCHAR(255) NOT NULL,
#     product_id INTEGER,
#     PRIMARY KEY (id)
# );
#
# CREATE TABLE address (
#     id BIGINT NOT NULL AUTO_INCREMENT,
#     street_name VARCHAR(255) NOT NULL,
#     street_number VARCHAR(255) NOT NULL,
#     town VARCHAR(255) NOT NULL,
#     postal_code VARCHAR(255) NOT NULL,
#     PRIMARY KEY (id)
# );
