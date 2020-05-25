package com.pollaid.api.poll.service;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.poll.dto.AnswersDto;
import com.pollaid.api.poll.dto.PollDto;
import com.pollaid.api.poll.dto.UpdatePollDto;
import com.pollaid.api.poll.dto.NewPollDto;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PollService {

    @Transactional
    public IdResponseDto createPoll(NewPollDto pollDto);

    @Transactional
    public IdResponseDto updatePoll(UpdatePollDto pollDto, Long pollId);


    public Optional<PollDto> getPoll(Long pollId);

    @Transactional
    public void deletePoll(Long pollId);

    public Optional<AnswersDto> getAnswers(Long pollId);

}
