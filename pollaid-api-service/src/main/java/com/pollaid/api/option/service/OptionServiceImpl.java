package com.pollaid.api.option.service;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.common.exception.EntityNotFound;
import com.pollaid.api.option.dto.OptionDto;
import com.pollaid.api.option.model.OptionEntity;
import com.pollaid.api.option.repository.OptionRepository;
import com.pollaid.api.poll.model.PollEntity;
import com.pollaid.api.poll.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@Slf4j
@AllArgsConstructor
public class OptionServiceImpl implements OptionService {

    private static final String ENTITY = "Option";
    private static final String POLL_ENTITY = "Poll";

    private final PollRepository pollRepository;

    private final OptionRepository optionRepository;

    @Override
    public IdResponseDto createOption(OptionDto optionDto, Long pollId) {

        PollEntity pollEntity = getPoll(pollId);

        OptionEntity optionEntity = optionRepository.save(OptionEntity.builder()
                .poll(pollEntity)
                .description(optionDto.getDescription())
                .build());

        return IdResponseDto.builder()
                .id(optionEntity.getId())
                .build();
    }

    @Override
    public IdResponseDto updateOption(OptionDto optionDto,Long pollId, Long optionId) {

        getPoll(pollId);

        OptionEntity optionEntity = optionRepository.findById(optionId)
                .orElseThrow(() -> new EntityNotFound(ENTITY, optionId));

        optionEntity.setDescription(optionDto.getDescription());
        optionRepository.save(optionEntity);

        return IdResponseDto.builder()
                .id(optionEntity.getId())
                .build();
    }

    @Override
    public void deleteOption(Long pollId, Long optionId) {
        OptionEntity optionEntity = optionRepository.findById(optionId)
                .orElseThrow(() -> new EntityNotFound(ENTITY, optionId));
        optionRepository.deleteById(optionEntity.getId());
    }

    private PollEntity getPoll (Long pollId){
        return  pollRepository.findById(pollId).orElseThrow(() -> new EntityNotFound(POLL_ENTITY, pollId));
    }
}
