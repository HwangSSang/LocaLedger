package com.project.localledger.Controller.login;

import com.project.localledger.dto.login.LoginForm;
import com.project.localledger.entity.login.Login;
import com.project.localledger.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                Model model) {
        if(error != null){
            model.addAttribute("errorMessage","아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        if(logout != null){
            model.addAttribute("successMessage", "로그아웃 되었습니다.");
        }
        return "login/loginMain";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Login> optionalLogin = loginRepository.findByUsername(username);

        if(optionalLogin.isPresent()){
            Login login = optionalLogin.get();
            if(login.getPassword().equals(password)){
                return  "redirect:/account";
            }
        }
        model.addAttribute("errorMessage","아이디 또는 비밀번호가 올바르지 않습니다.");
        return "login/loginMain";
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        return "login/registerMain";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String confirmPassword,
                                  Model model){
        if(!password.equals(confirmPassword)){
            model.addAttribute("errorMessage","비밀번호가 일치하지 않습니다.");
            return "login/registerMain";
        }

        if(loginRepository.findByUsername(username).isPresent()){
            model.addAttribute("errorMessage","이미 존재하는 아이디입니다.");
            return "login/registerMain";
        }

        String encodedPassword = passwordEncoder.encode(password);

        Login newlogin = new Login(null, username, encodedPassword);
        loginRepository.save(newlogin);

        System.out.println("회원가입 시도 : username = " + username + ", password = " + encodedPassword);

        model.addAttribute("successMessage","회원가입이 완료되었습니다! 로그인 해주세요");
        return "login/loginMain";
    }
}
