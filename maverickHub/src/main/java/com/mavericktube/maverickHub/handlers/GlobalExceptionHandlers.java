package com.mavericktube.maverickHub.handlers;

import com.mavericktube.maverickHub.exceptions.MediaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandlers {
    @ExceptionHandler(MediaException.class)
    @ResponseBody
    public ResponseEntity<?> handleMediaUploadFailed(MediaException exception){
        return ResponseEntity.status(BAD_REQUEST)
                .body(Map.of
                        ("error", exception.getMessage(),
                        "success", false
                ));
    }
}
