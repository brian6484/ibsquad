package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.posts.Posts;
import com.gbc.ibsquad.domain.posts.PostsRepository;
import com.gbc.ibsquad.dto.posts.PostsSaveRequestDto;
import com.gbc.ibsquad.service.posts.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping("/posts")
    public String savePosts(){
        return "posts/post";
    }

    @PostMapping("/posts")
    public String savePosts(@RequestParam String title,
                            @RequestParam String content,
                            @RequestParam String author,
                            Model model){
        Posts test = Posts.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
        model.addAttribute("post", test);
        return "posts/post";
    }



//    @PostMapping("/posts")
//    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
//        return postsService.save(dto);
//    }


}
