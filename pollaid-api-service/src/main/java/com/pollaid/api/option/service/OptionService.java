package com.pollaid.api.option.service;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.option.dto.OptionDto;

import javax.transaction.Transactional;

public interface OptionService {

    @Transactional
    public IdResponseDto createOption(OptionDto optionDto, Long pollId);

    @Transactional
    public IdResponseDto updateOption(OptionDto optionDto, Long pollId, Long optionId);

    @Transactional
    public void deleteOption(Long pollId, Long optionId);

}
