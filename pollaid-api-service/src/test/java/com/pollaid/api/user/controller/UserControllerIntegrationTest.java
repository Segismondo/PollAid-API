package com.pollaid.api.user.controller;

import com.google.gson.Gson;
import com.pollaid.api.AbstractIntegrationTest;
import com.pollaid.api.user.dto.NewUserDto;
import com.pollaid.api.user.dto.UpdateUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

public class UserControllerIntegrationTest extends AbstractIntegrationTest {

    private Gson gson = new Gson();

    @LocalServerPort
    private int port;

    @Test
    void userControllerIntegrationTest(){

        //given
        final NewUserDto newUser = UserFixture.newUser();
        final UpdateUserDto updatedUser = UserFixture.updatedUser();

        //when
        final int newUserId = given().
                port(port).contentType("application/json").body(gson.toJson(newUser))
                .when()
                .post(UserRoutes.CREATE_USER)
                .then()
                .statusCode(201).extract().path("id");

        final String newUserUsername = given().
                port(port)
                .when()
                .get(UserRoutes.GET_USER, newUserId)
                .then()
                .statusCode(200).extract().path("userName");

        final int updatedUserId = given().
                port(port).contentType("application/json").body(gson.toJson(updatedUser))
                .when()
                .put(UserRoutes.UPDATE_USER, newUserId)
                .then()
                .statusCode(200).extract().path("id");

        final String updatedUserUsername = given().
                port(port)
                .when()
                .get(UserRoutes.GET_USER, newUserId)
                .then()
                .statusCode(200).extract().path("userName");

        given().
                port(port)
                .when()
                .delete(UserRoutes.DELETE_USER, updatedUserId)
                .then()
                .statusCode(200);

        //then
        assertThat(newUserId).isEqualTo(updatedUserId);
        assertThat(newUserUsername).isEqualTo(UserFixture.USER_USERNAME);
        assertThat(updatedUserUsername).isEqualTo(UserFixture.UPDATED_USER_USERNAME);

    }
}
