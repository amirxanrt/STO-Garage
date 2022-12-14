package com.example.orders.error;



import com.example.orders.exception.ForbiddenException;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.exception.ServiceAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handle(final MethodArgumentNotValidException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.ARGUMENT_NOT_VALID);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseDTO handle(final ForbiddenException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.EXECUTE_ACCESS_FORBIDDEN);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handle(final ServiceAlreadyExistsException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.SERVICE_ALREADY_EXISTS);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handle(final OrderNotFoundException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.THE_ORDER_CANNOT_FIND_THE_DATA);
    }
}
