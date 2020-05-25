CREATE TABLE poll
(
    id              BIGSERIAL    NOT NULL PRIMARY KEY,
    question        VARCHAR      NOT NULL,
    type            VARCHAR      NOT NULL,
    category        VARCHAR      NOT NULL,
    status          VARCHAR      NOT NULL
);