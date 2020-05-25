package com.pollaid.api.optionAnswer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OptionAnswerDto {

    public static OptionAnswerDto fromEntity(){
        return OptionAnswerDto.builder()
                .build();
    }

}