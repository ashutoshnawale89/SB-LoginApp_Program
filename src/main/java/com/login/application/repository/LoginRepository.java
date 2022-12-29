package com.login.application.repository;

import com.login.application.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Integer> {

    LoginModel findByUserId(String userId);

    LoginModel findByPassword(String tokenPasswrd);
}
