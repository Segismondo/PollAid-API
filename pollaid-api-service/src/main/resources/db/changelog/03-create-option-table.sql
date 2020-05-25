CREATE TABLE option
(
    id              BIGSERIAL   NOT NULL PRIMARY KEY,
    poll_id         BIGSERIAL   NOT NULL,
    description     VARCHAR     NOT NULL,

    CONSTRAINT fk_poll_option_id FOREIGN KEY (poll_id) REFERENCES poll (id) ON DELETE CASCADE
);