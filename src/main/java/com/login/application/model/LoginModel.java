package com.login.application.model;

import com.login.application.dto.LoginDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userId;

    private String password;

    public LoginModel(int id, LoginDTO loginDTO) {
        this.id = id;
        this.userId = loginDTO.getUserId();
        this.password = loginDTO.getPassword();
    }

    public LoginModel(LoginDTO loginDTO) {
        this.id = id;
        this.userId = loginDTO.getUserId();
        this.password = loginDTO.getPassword();
    }

//    public LoginModel orElseThrow(Supplier<Throwable> throwableSupplier) {
//        throw new LoginUserException("Enter Valid User Id");
//    }
}
