package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "user not found")
@Getter
public class UserNotFoundException extends RuntimeException {

    private long userId;

    public UserNotFoundException(long userId){
        this.userId = userId;
    }

    @Override
    public String getMessage(){
        return String.format("User with id '%s' not found", getUserId());
    }


}