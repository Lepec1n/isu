package com.isu.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "status not found")
public class StatusNotFoundException extends RuntimeException {
}