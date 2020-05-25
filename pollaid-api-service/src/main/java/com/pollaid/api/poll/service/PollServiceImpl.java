package com.pollaid.api.poll.service;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.option.service.OptionService;
import com.pollaid.api.poll.dto.AnswersDto;
import com.pollaid.api.poll.dto.NewPollDto;
import com.pollaid.api.poll.dto.PollDto;
import com.pollaid.api.poll.dto.UpdatePollDto;
import com.pollaid.api.poll.enums.PollCategory;
import com.pollaid.api.poll.enums.PollType;
import com.pollaid.api.poll.exception.PollEntityNotFound;
import com.pollaid.api.poll.model.PollEntity;
import com.pollaid.api.poll.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;


@Validated
@Service
@Slf4j
@AllArgsConstructor
public class PollServiceImpl implements PollService{

    private final PollRepository pollRepository;

    private final OptionService optionService;

    @Override
    public IdResponseDto createPoll(NewPollDto pollDto) {

        PollEntity pollEntity = pollRepository.save(PollEntity.builder()
                .question(pollDto.getQuestion())
                .type(PollType.valueOf(pollDto.getType().replaceAll(" ", "_").toUpperCase()))
                .category(PollCategory.valueOf(pollDto.getCategory().toUpperCase()))
                .build());

        pollDto.getOptions().stream().forEach(option -> optionService.createOption(option, pollEntity.getId()));

        return IdResponseDto.builder()
                .id(pollEntity.getId())
                .build();
    }
    @Override
    public IdResponseDto updatePoll(UpdatePollDto pollDto, Long pollId) {
        PollEntity pollEntity = pollRepository.findById(pollId)
                .orElseThrow(() -> new PollEntityNotFound(pollId));

        pollEntity.setQuestion(pollDto.getQuestion());
        pollEntity.setType(PollType.valueOf(pollDto.getType().replaceAll(" ", "_").toUpperCase()));
        pollEntity.setCategory(PollCategory.valueOf(pollDto.getCategory().toUpperCase()));
        pollRepository.save(pollEntity);

        return IdResponseDto.builder()
                .id(pollEntity.getId())
                .build();
    }

    @Override
    public Optional<PollDto> getPoll(Long pollId) {
        return pollRepository.findById(pollId)
                .map(PollDto::fromEntity);
    }

    @Override
    public void deletePoll(Long pollId) {
        pollRepository.findById(pollId).ifPresent(poll -> pollRepository.deleteById(poll.getId()));
    }

    @Override
    public Optional<AnswersDto> getAnswers(Long pollId) {
        return pollRepository.findById(pollId)
                .map(AnswersDto::fromEntity);
    }
}
