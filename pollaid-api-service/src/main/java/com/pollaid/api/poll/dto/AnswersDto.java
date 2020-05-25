package com.pollaid.api.poll.dto;

import com.pollaid.api.answer.dto.AnswerDto;
import com.pollaid.api.poll.model.PollEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
public class AnswersDto {

    private Set<AnswerDto> answers;

    public static AnswersDto fromEntity(PollEntity pollEntity){

        return AnswersDto.builder()
                .answers(pollEntity.getAnswers().stream().map(answer -> AnswerDto.fromEntity(answer)).collect(Collectors.toSet()))
                .build();
    }
}
