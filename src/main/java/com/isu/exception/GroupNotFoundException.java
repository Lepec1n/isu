package com.isu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "group not found")
@Getter
public class GroupNotFoundException extends RuntimeException {

    private long groupId;

    public GroupNotFoundException(long groupId){
        this.groupId = groupId;
    }

    @Override
    public String getMessage(){
        return String.format("Group with id '%s' not found", getGroupId());
    }


}