package com.pollaid.api.poll.dto;

import com.pollaid.api.option.dto.OptionDto;
import com.pollaid.api.poll.model.PollEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;


@Builder
@Data
public class PollDto {
    private String status;
    private String question;
    private String type;
    private String category;
    private Set<OptionDto> options;

    public static PollDto fromEntity(PollEntity pollEntity){

        return PollDto.builder()
                .question(pollEntity.getQuestion())
                .category(pollEntity.getCategory().toString())
                .type(pollEntity.getType().toString())
                .status(pollEntity.getStatus().toString())
                .options(pollEntity.getOptions().stream().map(option -> OptionDto.fromEntity(option)).collect(Collectors.toSet()))
                .build();
    }
}
