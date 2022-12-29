package com.login.application.service;

import com.login.application.dto.LoginDTO;
import com.login.application.exception.LoginUserException;
import com.login.application.model.LoginModel;
import com.login.application.repository.LoginRepository;
import com.login.application.util.EventMailSender;
import com.login.application.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    EventMailSender mailSender;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoders;
/* Register The User Inside App
 * check The All Validation
 */
    @Override
    public LoginModel registrationLogin(LoginDTO loginDTO) {
        LoginModel addData = new LoginModel(loginDTO);
        String tokenPasswrd = bCryptPasswordEncoders.encode(addData.getPassword());
        addData.setPassword(tokenPasswrd);
        loginRepository.save(addData);
        //Send The Message
        mailSender.sendMail(addData.getUserId());
        return addData;
    }
    /*Login The User inside App
    *   if The User ID and Password is Correct then Login Successfully....
    *   else throw Exception Message
     */
    @Override
    public String loginUserData(LoginDTO loginDTO) throws Throwable {
        // to check The User Are Available Or Not
        // if Not Throw The Exception
        if(loginRepository.findByUserId(loginDTO.getUserId())==null){
            throw new LoginUserException("User Id Is Incorrect.......");
        }else {
            LoginModel findUser = loginRepository.findByUserId(loginDTO.getUserId());
            // To check The Password ......
            boolean tokenPasswrd = bCryptPasswordEncoders.matches(loginDTO.getPassword(), findUser.getPassword());
            // create The Token Using UserId
            if (tokenPasswrd) {
                String token = tokenUtil.createToken(findUser.getId());
                return token;
            } else {
                throw new LoginUserException("Password is Incorrect... Please Try Again");
            }
        }
    }
}

