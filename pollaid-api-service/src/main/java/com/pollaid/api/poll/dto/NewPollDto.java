package com.pollaid.api.poll.dto;

import com.pollaid.api.option.dto.OptionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewPollDto {
    private String question;
    private String type;
    private String category;
    private Set<OptionDto> options;
}
