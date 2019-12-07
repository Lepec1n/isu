package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "literature request not found")
@Getter
public class LiteratureNotFoundException extends RuntimeException {

    private long literatureId;

    public LiteratureNotFoundException(long literatureId){
        this.literatureId = literatureId;
    }

    @Override
    public String getMessage(){
        return String.format("Literature with id '%s' not found",
                getLiteratureId());
    }


}