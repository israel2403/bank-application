-- Insert some data into the customers table
INSERT INTO
  customers (id, email, pwd, role, created_at, updated_at)
VALUES
  (
    UUID_TO_BIN('1c1d35c7-5d37-44d0-9a08-7dabeee053a0'),
    'happy@example.com',
    '{noop}EazyBytes@12345',
    'read',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  customers (id, email, pwd, role, created_at, updated_at)
VALUES
  (
    UUID_TO_BIN('1c1d35c7-5d37-44d0-9a08-7dabeee053a1'),
    'admin@example.com',
    '{bcrypt}$2a$12$kxKHBgOggNy/MT2yPhC1OeHdt4YzSnGGCH0TkqNgnZmrtIW/J9b0y',
    'role',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );