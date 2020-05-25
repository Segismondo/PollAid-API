package com.pollaid.api.answer.dto;

import com.pollaid.api.answer.model.AnswerEntity;
import com.pollaid.api.optionAnswer.dto.OptionAnswerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Set<OptionAnswerDto> optionAnswers;

    public static AnswerDto fromEntity(AnswerEntity answerEntity){
        return AnswerDto.builder()
                .optionAnswers(answerEntity.getOptionAnswers().stream().map(optionAnswer -> OptionAnswerDto.fromEntity()).collect(Collectors.toSet()))
                .build();
    }
}