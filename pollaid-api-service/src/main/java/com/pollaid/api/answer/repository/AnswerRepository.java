package com.pollaid.api.answer.repository;

import com.pollaid.api.answer.model.AnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {
}
