package com.pollaid.api.poll.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PollRoutes {
    private static final String MAIN_PATH = "/poll/";

    public static final String CREATE_POLL = MAIN_PATH;
    static final String UPDATE_POLL = MAIN_PATH + "{pollId}";
    public static final String GET_POLL = MAIN_PATH + "{pollId}";
    public static final String DELETE_POLL = MAIN_PATH + "{pollId}";
    public static final String GET_POLL_ANSWERS = MAIN_PATH + "{pollId}/answers/";



}
