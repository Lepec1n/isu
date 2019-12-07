package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "discipline not found")
@Getter
public class DisciplineNameNotFoundException extends RuntimeException {

    private String name;

    public DisciplineNameNotFoundException(String name){
        this.name = name;
    }

    @Override
    public String getMessage(){
        return String.format("Discipline with name '%s' not found",
                getName());
    }
}