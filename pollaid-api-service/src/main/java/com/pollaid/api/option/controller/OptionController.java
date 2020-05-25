package com.pollaid.api.option.controller;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.option.dto.OptionDto;
import com.pollaid.api.option.service.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class OptionController {

    @Autowired
    private final OptionService optionService;

    @PostMapping(path = OptionRoutes.CREATE_OPTION)
    public ResponseEntity<IdResponseDto> createOption(@Valid @RequestBody OptionDto optionDto, @PathVariable Long pollId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(optionService.createOption(optionDto, pollId));
    }

    @PutMapping(path = OptionRoutes.UPDATE_OPTION)
    public ResponseEntity<IdResponseDto> updateOption(@Valid @RequestBody OptionDto optionDto, @PathVariable Long pollId, @PathVariable Long optionId) {
        return ResponseEntity.ok(optionService.updateOption(optionDto, pollId, optionId));
    }

    @DeleteMapping(path = OptionRoutes.DELETE_OPTION)
    public ResponseEntity<Void> deleteOption(@PathVariable Long pollId, @PathVariable Long optionId){
        optionService.deleteOption(pollId, optionId);
        return ResponseEntity.ok().build();
    }

}
