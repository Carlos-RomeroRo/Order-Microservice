CREATE TABLE orden(
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    status VARCHAR(255) NOT NULL CHECK (status IN ('PENDIENTE', 'ENVIADO', 'ENTREGADO'))
);