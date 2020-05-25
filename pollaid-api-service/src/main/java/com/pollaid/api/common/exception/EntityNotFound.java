package com.pollaid.api.common.exception;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(final String entity, Long pollId){
        super(entity + " has not been found for Id: " + pollId);
    }
}
