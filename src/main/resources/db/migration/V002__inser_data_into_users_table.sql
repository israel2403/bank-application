INSERT IGNORE INTO users VALUES ('user', '$2a$10$1Q7Z6Q6Z', 1); # password is '$2a$12$/CTubOc8Ihobg/4bWpNyN.3akT4WlK3250wz.Vpti9jWgBLMA1yDW'
INSERT IGNORE INTO authorities VALUES ('user', 'read');

INSERT IGNORE INTO users VALUES ('admin', '$2a$12$6eBg/QVMV4YJiAabXT4SR.mNnsLN58VN9UNm6uuAvmeA/eaibGQeS', 1); # password is '$2a$10$1Q7Z6Q6ZG'
INSERT IGNORE INTO authorities VALUES ('admin', 'admin');