package com.pollaid.api.answer.controller;

import com.pollaid.api.answer.dto.AnswerDto;
import com.pollaid.api.answer.service.AnswerService;
import com.pollaid.api.common.dto.IdResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping(path = AnswerRoutes.CREATE_ANSWER)
    public ResponseEntity<IdResponseDto> createAnswer(@Valid @RequestBody AnswerDto answerDto, @PathVariable Long pollId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerService.createAnswer(answerDto, pollId));
    }

}
