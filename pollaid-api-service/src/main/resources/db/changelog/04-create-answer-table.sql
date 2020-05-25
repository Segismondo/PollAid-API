CREATE TABLE answer
(
    id              BIGSERIAL   NOT NULL PRIMARY KEY,
    poll_id         BIGSERIAL   NOT NULL,

    CONSTRAINT fk_poll_answer_id FOREIGN KEY (poll_id) REFERENCES poll (id) ON DELETE CASCADE
);