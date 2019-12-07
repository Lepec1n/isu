package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "literature request not found")
@Getter
public class RequestNotFoundException extends RuntimeException {

    private long literatureRequestId;

    public RequestNotFoundException(long literatureRequestId){
        this.literatureRequestId = literatureRequestId;
    }

    @Override
    public String getMessage(){
        return String.format("Literature Request with id '%s' not found",
                getLiteratureRequestId());
    }


}