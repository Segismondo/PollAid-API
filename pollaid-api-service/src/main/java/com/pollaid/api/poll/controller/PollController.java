package com.pollaid.api.poll.controller;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.poll.dto.AnswersDto;
import com.pollaid.api.poll.dto.PollDto;
import com.pollaid.api.poll.dto.UpdatePollDto;
import com.pollaid.api.poll.service.PollServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pollaid.api.poll.dto.NewPollDto;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PollController {

    private final PollServiceImpl pollService;

    @PostMapping (path = PollRoutes.CREATE_POLL)
    public ResponseEntity<IdResponseDto> createPoll(@Valid @RequestBody NewPollDto pollDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pollService.createPoll(pollDto));
    }

    @PutMapping(path = PollRoutes.UPDATE_POLL)
    public ResponseEntity<IdResponseDto> updatePoll(@Valid @RequestBody UpdatePollDto pollDto, @PathVariable Long pollId) {
        return ResponseEntity.ok(pollService.updatePoll(pollDto, pollId));
    }

    @GetMapping(path = PollRoutes.GET_POLL)
    public ResponseEntity<PollDto> getPoll(@PathVariable Long pollId) {
        return ResponseEntity.of(pollService.getPoll(pollId));
    }

    @DeleteMapping(path = PollRoutes.DELETE_POLL)
    public ResponseEntity<Void> deletePoll(@PathVariable Long pollId){
        pollService.deletePoll(pollId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = PollRoutes.GET_POLL_ANSWERS)
    public ResponseEntity<AnswersDto> getAnswers(@PathVariable Long pollId) {
        return ResponseEntity.of(pollService.getAnswers(pollId));
    }

}
