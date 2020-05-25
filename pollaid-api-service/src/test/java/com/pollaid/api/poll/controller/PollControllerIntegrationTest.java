package com.pollaid.api.poll.controller;

import com.google.gson.Gson;
import com.pollaid.api.AbstractIntegrationTest;
import com.pollaid.api.poll.dto.NewPollDto;
import com.pollaid.api.poll.dto.UpdatePollDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

public class PollControllerIntegrationTest extends AbstractIntegrationTest {

    private Gson gson = new Gson();

    @LocalServerPort
    private int port;

    @Test
    void pollControllerIntegrationTest(){

        //given
        final NewPollDto newPoll = PollFixture.newPoll();
        final UpdatePollDto updatedPoll = PollFixture.updatedPoll();

        //when
        final int newPollId = given().
                port(port).contentType("application/json").body(gson.toJson(newPoll))
                .when()
                .post(PollRoutes.CREATE_POLL)
                .then()
                .statusCode(201).extract().path("id");

        final String newPollQuestion = given().
                port(port)
                .when()
                .get(PollRoutes.GET_POLL, newPollId)
                .then()
                .statusCode(200).extract().path("question");

        final int updatedPollId = given().
                port(port).contentType("application/json").body(gson.toJson(updatedPoll))
                .when()
                .put(PollRoutes.UPDATE_POLL, newPollId)
                .then()
                .statusCode(200).extract().path("id");

        final String updatedPollQuestion = given().
                port(port)
                .when()
                .get(PollRoutes.GET_POLL, newPollId)
                .then()
                .statusCode(200).extract().path("question");

        given().
                port(port)
                .when()
                .delete(PollRoutes.DELETE_POLL, updatedPollId)
                .then()
                .statusCode(200);

        //then
        assertThat(newPollId).isEqualTo(updatedPollId);
        assertThat(newPollQuestion).isEqualTo(PollFixture.POLL_QUESTION);
        assertThat(updatedPollQuestion).isEqualTo(PollFixture.UPDATED_POLL_QUESTION);

    }
}
