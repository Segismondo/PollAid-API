package com.pollaid.api.answer.service;

import com.pollaid.api.answer.dto.AnswerDto;
import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.poll.dto.UpdatePollDto;

import javax.transaction.Transactional;

public interface AnswerService {
    @Transactional
    public IdResponseDto createAnswer(AnswerDto answerDto, Long pollId);
}
