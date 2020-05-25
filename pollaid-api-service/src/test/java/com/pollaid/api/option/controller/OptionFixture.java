package com.pollaid.api.option.controller;

import com.pollaid.api.option.dto.OptionDto;

public class OptionFixture {

    static final String POLL_OPTION = "Fine, I could be better";

    static final String UPDATED_POLL_OPTION = "Cristiano Ronaldo";

    public static OptionDto newOption(){
        return OptionDto.builder()
                .description(POLL_OPTION)
                .build();
    }

    public static OptionDto updatedOption(){
        return OptionDto.builder()
                .description(UPDATED_POLL_OPTION)
                .build();
    }

}
