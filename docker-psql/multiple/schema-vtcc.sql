-- CREATE TYPE IsleType AS ENUM ('Kitchen', 'Room','Garden','Misc');

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE product
(
    id        UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    isle_type VARCHAR(255) NOT NULL
);