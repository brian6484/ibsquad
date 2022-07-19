package com.gbc.ibsquad.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
