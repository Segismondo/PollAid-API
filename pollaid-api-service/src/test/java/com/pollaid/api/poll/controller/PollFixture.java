package com.pollaid.api.poll.controller;

import com.pollaid.api.poll.dto.NewPollDto;
import com.pollaid.api.poll.dto.UpdatePollDto;

import java.util.Collections;
import java.util.Set;

public class PollFixture {

    static final String POLL_QUESTION = "How do you feel?";
    static final String POLL_TYPE = "One Choice";
    static final String POLL_CATEGORY = "Health";
    static final Set POLL_OPTIONS = Collections.emptySet();

    static final String UPDATED_POLL_QUESTION = "Which is the best football player of the world?";
    static final String UPDATED_POLL_TYPE = "One Choice";
    static final String UPDATED_POLL_CATEGORY = "Sports";

    public static NewPollDto newPoll(){
        return NewPollDto.builder()
                .question(POLL_QUESTION)
                .type(POLL_TYPE)
                .category(POLL_CATEGORY)
                .options(POLL_OPTIONS)
                .build();
    }

    public static UpdatePollDto updatedPoll(){
        return UpdatePollDto.builder()
                .question(UPDATED_POLL_QUESTION)
                .type(UPDATED_POLL_TYPE)
                .category(UPDATED_POLL_CATEGORY)
                .build();
    }

}
