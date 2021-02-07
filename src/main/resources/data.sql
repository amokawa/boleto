DROP TABLE IF EXISTS boleto;

CREATE TABLE boleto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(250) NOT NULL,
    expire_date DATE NOT NULL,
    car_id BIGINT NOT NULL,
    car_brand VARCHAR(250) NOT NULL,
    car_model VARCHAR(250) NOT NULL,
    car_price DECIMAL(10,2) NOT NULL,
    CONSTRAINT UC_boleto UNIQUE (car_id)
);

INSERT INTO boleto (code, expire_date, car_id, car_brand, car_model, car_price) VALUES
    ('1234567890', '2021-01-01', 1, 'Land Rover', 'Discovery Sport', 219999);