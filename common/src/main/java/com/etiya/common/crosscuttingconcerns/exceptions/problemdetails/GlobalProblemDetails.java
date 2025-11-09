package com.etiya.common.crosscuttingconcerns.exceptions.problemdetails;

import com.etiya.common.crosscuttingconcerns.exceptions.constants.ExceptionMessages;
import org.springframework.http.HttpStatus;

public class GlobalProblemDetails extends ProblemDetails{
    public GlobalProblemDetails(){
        setTitle(ExceptionMessages.GLOBAL_ERROR);
        setType(ExceptionMessages.TYPE_EXCEPTION);
        setStatus(HttpStatus.BAD_REQUEST.value());
    }
}
