package com.pollaid.api.poll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UpdatePollDto{
    private String question;
    private String type;
    private String category;
}
