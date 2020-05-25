package com.pollaid.api.optionAnswer.service;

import com.pollaid.api.answer.model.AnswerEntity;
import com.pollaid.api.answer.repository.AnswerRepository;
import com.pollaid.api.common.exception.EntityNotFound;
import com.pollaid.api.option.model.OptionEntity;
import com.pollaid.api.option.repository.OptionRepository;
import com.pollaid.api.optionAnswer.dto.OptionAnswerDto;
import com.pollaid.api.optionAnswer.model.OptionAnswerEntity;
import com.pollaid.api.optionAnswer.repository.OptionAnswerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@Slf4j
@AllArgsConstructor
public class OptionAnswerServiceImpl implements OptionAnswerService{

    private static final String ANSWER_ENTITY = "Answer";
    private static final String OPTION_ENTITY = "Option";

    private final OptionAnswerRepository optionAnswerRepository;
    private final AnswerRepository answerRepository;
    private final OptionRepository optionRepository;

    public void createOptionAnswer(OptionAnswerDto optionAnswerDto, Long answerId, Long optionId){

        optionAnswerRepository.save(OptionAnswerEntity.builder()
                .answer(getAnswer(answerId))
                .option(getOption(optionId))
                .build());
    }

    private AnswerEntity getAnswer (Long answerId){
        return  answerRepository.findById(answerId).orElseThrow(() -> new EntityNotFound(ANSWER_ENTITY, answerId));
    }

    private OptionEntity getOption (Long optionId){
        return  optionRepository.findById(optionId).orElseThrow(() -> new EntityNotFound(OPTION_ENTITY, optionId));
    }
}
