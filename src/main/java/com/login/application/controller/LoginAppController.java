package com.login.application.controller;

import com.login.application.dto.LoginDTO;
import com.login.application.dto.ResponseDto;
import com.login.application.model.LoginModel;
import com.login.application.service.ILoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginservice")
public class LoginAppController {
    @Autowired
    private ILoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(
            @Valid @RequestBody LoginDTO loginDTO) {
        LoginModel addData=null;
        addData = loginService.registrationLogin(loginDTO);
        ResponseDto respDTO=new ResponseDto(" User Register Data Successfully ",addData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }
    @PostMapping ("/login")
    public ResponseEntity<ResponseDto> getAddressBookDataByToken(@Valid @RequestBody LoginDTO loginDTO) throws Throwable {
        String addDataList=null;
        addDataList =loginService.loginUserData(loginDTO);
        ResponseDto respDTO=new ResponseDto("Login Successfully Done...... ",addDataList);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }
}
