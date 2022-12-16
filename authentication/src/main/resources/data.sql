INSERT INTO users(username, password, enabled)
VALUES('user', 'user', true);

INSERT INTO users(username, password, enabled)
VALUES('admin', 'admin', true);

INSERT INTO authorities(username, authority)
VALUES('user', 'USER');

INSERT INTO authorities(username, authority)
VALUES('admin', 'ADMIN');