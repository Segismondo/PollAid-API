package com.pollaid.api.option.dto;

import com.pollaid.api.option.model.OptionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto {
    private String description;

    public static OptionDto fromEntity(OptionEntity optionEntity){
        return OptionDto.builder()
                .description(optionEntity.getDescription())
                .build();
    }
}
