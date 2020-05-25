package com.pollaid.api.poll.repository;

import com.pollaid.api.poll.model.PollEntity;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<PollEntity, Long> {
}
