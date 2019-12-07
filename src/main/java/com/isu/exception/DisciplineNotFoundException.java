package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "discipline not found")
@Getter
public class DisciplineNotFoundException extends RuntimeException {

    private long disciplineId;

    public DisciplineNotFoundException(long disciplineId){
        this.disciplineId = disciplineId;
    }

    @Override
    public String getMessage(){
        return String.format("Discipline with id '%s' not found",
                getDisciplineId());
    }


}