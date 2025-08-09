
-- Drop existing tables if they exist (for re-import safety)
DROP TABLE IF EXISTS meisais;
DROP TABLE IF EXISTS kouzas;
DROP TABLE IF EXISTS users;

-- users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password_digest VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- kouzas table
CREATE TABLE kouzas (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    kingaku INTEGER,
    user_id INTEGER NOT NULL,
    bank_bangou VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- meisais table
CREATE TABLE meisais (
    id SERIAL PRIMARY KEY,
    date DATE,
    naiyou TEXT,
    nyuukin INTEGER,
    syuukin INTEGER,
    kouza_id INTEGER NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (kouza_id) REFERENCES kouzas(id)
);
