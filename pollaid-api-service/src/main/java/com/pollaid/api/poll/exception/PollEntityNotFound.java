package com.pollaid.api.poll.exception;

public class PollEntityNotFound extends RuntimeException{
    public PollEntityNotFound(Long pollId){
        super("Poll has not been found for Id: " + pollId);
    }
}
