package com.project.localledger.dto.login;

import com.project.localledger.entity.login.Login;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
public class LoginForm {

    private Long id;
    private String userName;
    private String password;


    public Login toEntity() {
        return new Login(id, userName, password);
    }
}
