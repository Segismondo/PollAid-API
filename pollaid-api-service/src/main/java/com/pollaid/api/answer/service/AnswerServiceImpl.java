package com.pollaid.api.answer.service;

import com.pollaid.api.answer.dto.AnswerDto;
import com.pollaid.api.answer.model.AnswerEntity;
import com.pollaid.api.answer.repository.AnswerRepository;
import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.common.exception.EntityNotFound;
import com.pollaid.api.option.model.OptionEntity;
import com.pollaid.api.optionAnswer.dto.OptionAnswerDto;
import com.pollaid.api.optionAnswer.service.OptionAnswerService;
import com.pollaid.api.poll.model.PollEntity;
import com.pollaid.api.poll.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Iterator;

@Validated
@Service
@Slf4j
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private static final String POLL_ENTITY = "Poll";

    private final AnswerRepository answerRepository;
    private final PollRepository pollRepository;
    private final OptionAnswerService optionAnswerService;

    @Override
    public IdResponseDto createAnswer(AnswerDto answerDto, Long pollId){
        PollEntity pollEntity = getPoll(pollId);
        AnswerEntity answerEntity = answerRepository.save(AnswerEntity.builder()
                .poll(pollEntity)
                .build());

        Iterator<OptionEntity> options = pollEntity.getOptions().iterator();
        Iterator<OptionAnswerDto> optionAnswers = answerDto.getOptionAnswers().iterator();

        while (options.hasNext() && optionAnswers.hasNext()) {
            optionAnswerService.createOptionAnswer(optionAnswers.next(), answerEntity.getId(), options.next().getId());
        }

        return IdResponseDto.builder()
                .id(answerEntity.getId())
                .build();
    }

    private PollEntity getPoll (Long pollId){
        return  pollRepository.findById(pollId).orElseThrow(() -> new EntityNotFound(POLL_ENTITY, pollId));
    }
}
