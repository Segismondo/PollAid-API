CREATE TABLE client
(
    id              BIGSERIAL    NOT NULL PRIMARY KEY,
    first_name      VARCHAR      NOT NULL,
    user_name       VARCHAR      NOT NULL UNIQUE,
    email           VARCHAR      NOT NULL UNIQUE,
    password        VARCHAR      NOT NULL
);