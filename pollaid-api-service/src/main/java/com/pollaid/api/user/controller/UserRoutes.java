package com.pollaid.api.user.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE )
public class UserRoutes {
    private static final String MAIN_PATH = "/user/";

    static final String GET_USER = MAIN_PATH + "{userId}";

    static final String CREATE_USER = MAIN_PATH;

    static final String DELETE_USER = MAIN_PATH + "{userId}";

    static final String UPDATE_USER = MAIN_PATH + "{userId}";
}
