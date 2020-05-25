package com.pollaid.api.optionAnswer.service;

import com.pollaid.api.optionAnswer.dto.OptionAnswerDto;

import javax.transaction.Transactional;

public interface OptionAnswerService {

    @Transactional
    public void createOptionAnswer(OptionAnswerDto optionAnswerDto, Long answerId, Long optionId);
}
