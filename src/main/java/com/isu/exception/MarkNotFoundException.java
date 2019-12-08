package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "mark not found")
@Getter
public class MarkNotFoundException extends RuntimeException {

    private long markId;

    public MarkNotFoundException(long markId){
        this.markId = markId;
    }

    @Override
    public String getMessage(){
        return String.format("Mark with id '%s' not found",
                getMarkId());
    }


}