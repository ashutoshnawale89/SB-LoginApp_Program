package com.login.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotEmpty
    @Email(message = "userId Should Be same as Email")
    private String userId;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]{3,}[@#$%^&*!]{1}[0-9]{4,}$",message = "Password Should be Right Format")
    private String password;
}
