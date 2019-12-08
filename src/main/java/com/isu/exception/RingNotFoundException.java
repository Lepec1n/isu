package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ring not found")
@Getter
public class RingNotFoundException extends RuntimeException {

    private long ringId;

    public RingNotFoundException(long ringId){
        this.ringId = ringId;
    }

    @Override
    public String getMessage(){
        return String.format("Ring with id '%s' not found",
                getRingId());
    }


}