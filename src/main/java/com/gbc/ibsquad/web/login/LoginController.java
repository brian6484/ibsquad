package com.gbc.ibsquad.web.login;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        Member loginMember = loginService.login(form.getLoginId(),form.getPassword());
        log.info("login? {}",loginMember);

        if(loginMember==null){
            bindingResult.reject("login failed ! :<","ur id/password is wrong");
            return "login/loginForm";
        }
        return "redirect:/";
    }

}
