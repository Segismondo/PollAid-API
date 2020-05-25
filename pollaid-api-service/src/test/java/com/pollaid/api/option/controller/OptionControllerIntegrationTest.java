package com.pollaid.api.option.controller;

import com.google.gson.Gson;
import com.pollaid.api.AbstractIntegrationTest;
import com.pollaid.api.option.dto.OptionDto;
import com.pollaid.api.poll.controller.PollFixture;
import com.pollaid.api.poll.controller.PollRoutes;
import com.pollaid.api.poll.dto.NewPollDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OptionControllerIntegrationTest extends AbstractIntegrationTest {

    private Gson gson = new Gson();

    @LocalServerPort
    private int port;

    @Test
    void optionControllerIntegrationTest(){

        //given
        final NewPollDto newPoll = PollFixture.newPoll();
        final OptionDto newOption = OptionFixture.newOption();
        final OptionDto updatedOption = OptionFixture.updatedOption();

        //when
        final int pollId = given().
                port(port).contentType("application/json").body(gson.toJson(newPoll))
                .when()
                .post(PollRoutes.CREATE_POLL)
                .then()
                .statusCode(201).extract().path("id");

        final int newOptionId = given().
                port(port).contentType("application/json").body(gson.toJson(newOption))
                .when()
                .post(OptionRoutes.CREATE_OPTION, pollId)
                .then()
                .statusCode(201).extract().path("id");

        final int updatedOptionId = given().
                port(port).contentType("application/json").body(gson.toJson(updatedOption))
                .when()
                .put(OptionRoutes.UPDATE_OPTION, pollId, newOptionId)
                .then()
                .statusCode(200).extract().path("id");

        final List<OptionDto> options = given().
                port(port)
                .when()
                .get(PollRoutes.GET_POLL, pollId)
                .then()
                .statusCode(200).extract().path("options");

        given().
                port(port)
                .when()
                .delete(PollRoutes.DELETE_POLL, pollId)
                .then()
                .statusCode(200);

        //then
        assertThat(options.size()).isEqualTo(1);
        assertThat(updatedOptionId).isEqualTo(newOptionId);

    }
}