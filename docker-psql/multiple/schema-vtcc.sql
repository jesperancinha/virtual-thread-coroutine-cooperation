CREATE TYPE isle_type AS ENUM ('Kitchen', 'Room','Garden','Misc');

CREATE TABLE product
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    isle_type isle_type    NOT NULL
);