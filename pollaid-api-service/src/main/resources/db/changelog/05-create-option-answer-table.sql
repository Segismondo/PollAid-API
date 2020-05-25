CREATE TABLE option_answer
(
    id              BIGSERIAL   NOT NULL PRIMARY KEY,
    answer_id         BIGSERIAL   NOT NULL,
    option_id         BIGSERIAL   NOT NULL,

    CONSTRAINT fk_option_answer_poll_id FOREIGN KEY (answer_id) REFERENCES answer (id) ON DELETE CASCADE,
    CONSTRAINT fk_option_answer_id FOREIGN KEY (option_id) REFERENCES option (id) ON DELETE CASCADE
);