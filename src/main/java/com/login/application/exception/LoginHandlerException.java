package com.login.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.login.application.dto.*;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class LoginHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg= errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());

        ResponseDto responseDTO=new ResponseDto("Exception while processing REST Request",errMsg);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginUserException.class)
    public ResponseEntity<ResponseDto> handleAddressBookException(LoginUserException exception) {
        ResponseDto responseDTO=new ResponseDto("Exception while Processing REST Request ",exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}

