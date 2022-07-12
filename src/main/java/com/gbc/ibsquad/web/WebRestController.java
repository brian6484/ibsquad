package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.posts.PostsRepository;
import com.gbc.ibsquad.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

}