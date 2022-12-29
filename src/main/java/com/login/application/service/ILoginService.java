package com.login.application.service;

import com.login.application.dto.LoginDTO;
import com.login.application.model.LoginModel;

public interface ILoginService {

    LoginModel registrationLogin(LoginDTO loginDTO);

    String loginUserData(LoginDTO loginDTO) throws Throwable;

}
