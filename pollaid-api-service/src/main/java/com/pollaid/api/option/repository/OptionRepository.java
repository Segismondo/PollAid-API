package com.pollaid.api.option.repository;

import com.pollaid.api.option.model.OptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<OptionEntity, Long> {
}
