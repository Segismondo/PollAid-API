package com.pollaid.api.answer.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerRoutes {
    private static final String MAIN_PATH = "/poll/{pollId}/";

    static final String CREATE_ANSWER = MAIN_PATH + "answer/";

}
