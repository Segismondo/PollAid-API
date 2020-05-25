package com.pollaid.api.option.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionRoutes {
    private static final String MAIN_PATH = "/poll/{pollId}/";

    static final String CREATE_OPTION = MAIN_PATH + "option/";
    static final String UPDATE_OPTION = MAIN_PATH + "option/{optionId}";
    static final String DELETE_OPTION = MAIN_PATH + "option/{optionId}";

}
