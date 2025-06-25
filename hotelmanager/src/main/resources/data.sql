CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

-- utilizator admin/admin (parola criptată cu BCrypt)
INSERT INTO users (username, password, enabled) VALUES
('admin', '$2a$12$my0NwiejTdSdozGRWnpwjeyg7LxS8/09QhJPHKcjQQR4Bk4CKejti', true);

INSERT INTO authorities (username, authority) VALUES
('admin', 'ROLE_ADMIN');
